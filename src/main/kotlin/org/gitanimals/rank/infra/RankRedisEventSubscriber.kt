package org.gitanimals.rank.infra

import org.gitanimals.core.redis.RedisPubSubChannel
import org.slf4j.LoggerFactory
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

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

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
            this.setErrorHandler {
                logger.error("Fail to listen message ${it.message}", it)
            }
        }
    }
}
