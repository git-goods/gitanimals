package org.gitanimals.supports.deadletter

import org.gitanimals.core.redis.RedisPubSubChannel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class DeadLetterRedisMessageListenerConfiguration(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val deadLetterRelayEventListener: DeadLetterRelayEventListener,
) {

    @Bean
    fun deadLetterListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                deadLetterRelayEventListener,
                ChannelTopic(RedisPubSubChannel.SLACK_INTERACTED)
            )
        }
    }
}
