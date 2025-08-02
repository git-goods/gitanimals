package org.gitanimals.rank.infra.listener

import org.gitanimals.core.redis.RedisPubSubChannel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class RankRedisEventSubscriber(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val rankUpdateGuildContributionMessageListener: RankUpdateGuildContributionMessageListener,
    private val updateUserContributionMessageListener: UpdateUserContributionMessageListener,
) {

    @Bean
    fun rankRedisListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                updateUserContributionMessageListener,
                ChannelTopic(RedisPubSubChannel.USER_CONTRIBUTION_UPDATED),
            )
            this.addMessageListener(
                rankUpdateGuildContributionMessageListener,
                ChannelTopic(RedisPubSubChannel.GUILD_CONTRIBUTION_UPDATED),
            )
        }
    }
}
