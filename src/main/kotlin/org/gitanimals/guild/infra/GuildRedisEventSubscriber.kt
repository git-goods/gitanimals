package org.gitanimals.guild.infra

import org.gitanimals.core.redis.RedisPubSubChannel
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.Topic
import org.springframework.stereotype.Component

@Component
class GuildRedisEventSubscriber(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val updateGuildContributionMessageListener: UpdateGuildContributionMessageListener,
) {

    @Bean
    fun guildRedisListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                updateGuildContributionMessageListener,
                Topic { RedisPubSubChannel.USER_CONTRIBUTION_UPDATED },
            )
        }
    }
}
