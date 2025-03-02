package org.gitanimals.core.redis

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class RedisApplicationEventPublisherExtension(
    private val objectMapper: ObjectMapper,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @TransactionalEventListener(
        value = [TransactionCommitRedisPubSubEvent::class],
        phase = TransactionPhase.AFTER_COMMIT,
    )
    fun handleTransactionCommitRedisPubSubEvent(event: TransactionCommitRedisPubSubEvent) {
        runCatching {
            redisTemplate.convertAndSend(
                event.channel,
                objectMapper.writeValueAsString(event),
            )
        }.onFailure {
            logger.error("Cannot publish event to redis. event: $event, channel: ${event.channel}, source: ${event.source}")
        }
    }
}
