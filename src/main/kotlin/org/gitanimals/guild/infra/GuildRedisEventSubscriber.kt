package org.gitanimals.guild.infra

import org.gitanimals.core.redis.RedisPubSubChannel
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class GuildRedisEventSubscriber(
    private val redisConnectionFactory: RedisConnectionFactory,
    private val guildUpdateGuildContributionMessageListener: GuildUpdateGuildContributionMessageListener,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Bean
    fun guildRedisListenerContainer(): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            this.connectionFactory = redisConnectionFactory
            this.addMessageListener(
                guildUpdateGuildContributionMessageListener,
                ChannelTopic(RedisPubSubChannel.USER_CONTRIBUTION_UPDATED),
            )
            this.setErrorHandler {
                logger.error("Fail to listen message", it)
            }
        }
    }
}
