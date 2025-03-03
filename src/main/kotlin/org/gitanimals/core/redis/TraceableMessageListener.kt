package org.gitanimals.core.redis

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.StringRedisTemplate

abstract class TraceableMessageListener(
    private val redisTemplate: StringRedisTemplate,
    private val objectMapper: ObjectMapper,
): MessageListener {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        runCatching {
            val traceId: String = objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                object: TypeReference<Map<String, String>>(){},
            )["traceId"] ?: throw IllegalArgumentException("Cannot find traceId on message: $message")
            MDC.put(TRACE_ID, traceId)
            onMessage(message)
        }.onFailure {
            logger.error("Fail to listen message: $message, error: $it", it)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    abstract fun onMessage(message: Message)
}
