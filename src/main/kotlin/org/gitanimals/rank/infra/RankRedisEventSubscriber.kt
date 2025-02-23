package org.gitanimals.rank.infra

import org.gitanimals.core.redis.RedisPubSubChannel
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.Topic
import org.springframework.stereotype.Component

@Component
class RankRedisEventSubscriber(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val updateGuildContributionMessageListener: UpdateGuildContributionMessageListener,
    private val updateUserContributionMessageListener: UpdateUserContributionMessageListener,
) {

    @Bean
    fun rankRedisListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                updateUserContributionMessageListener,
                Topic { RedisPubSubChannel.USER_CONTRIBUTION_UPDATED },
            )
            this.addMessageListener(
                updateGuildContributionMessageListener,
                Topic { RedisPubSubChannel.GUILD_CONTRIBUTION_UPDATED },
            )
        }
    }
}
