package org.gitanimals.guild.infra

import org.gitanimals.core.redis.RedisPubSubChannel
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.stereotype.Component

@Component
class GuildRedisEventSubscriber(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val guildUpdateGuildContributionMessageListener: GuildUpdateGuildContributionMessageListener,
) {

    @Bean
    fun guildRedisListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                guildUpdateGuildContributionMessageListener,
                ChannelTopic(RedisPubSubChannel.USER_CONTRIBUTION_UPDATED),
            )
        }
    }
}
