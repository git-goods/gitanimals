package org.gitanimals.core.redis

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.event.EventListener
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class RedisPubSubEventListener(
    private val objectMapper: ObjectMapper,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Async
    @EventListener(value = [AsyncRedisPubSubEvent::class])
    fun handleAsyncRedisPubSubEvent(event: AsyncRedisPubSubEvent) {
        runCatching {
            val eventBody = objectMapper.writeValueAsString(event)
            redisTemplate.convertAndSend(
                event.channel,
                eventBody,
            )
            eventBody
        }.onSuccess {
            logger.info("Publish event: \"$it\" to channel: \"${event.channel}\"")
        }.onFailure {
            logger.error(
                "Cannot publish event to redis. event: $event, channel: ${event.channel}",
                it
            )
        }
    }
}
