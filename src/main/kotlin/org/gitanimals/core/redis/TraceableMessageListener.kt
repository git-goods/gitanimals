package org.gitanimals.core.redis

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.core.filter.MDCFilter
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.StringRedisTemplate

abstract class TraceableMessageListener(
    private val listenerName: String,
    private val redisTemplate: StringRedisTemplate,
    private val objectMapper: ObjectMapper,
) : MessageListener {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        runCatching {
            val request = objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                object : TypeReference<Map<String, String>>() {},
            )


            runCatching {
                request["traceId"] as String
            }.onSuccess {
                MDC.put(TRACE_ID, it)
            }
            runCatching {
                request["apiUserId"] as String
            }.onSuccess {
                MDC.put(MDCFilter.USER_ID, it)
            }

            logger.info("[$listenerName] request: $request")
            onMessage(message)
        }.onFailure {
            logger.error("Fail to listen message: $message, error: $it", it)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    abstract fun onMessage(message: Message)
}
