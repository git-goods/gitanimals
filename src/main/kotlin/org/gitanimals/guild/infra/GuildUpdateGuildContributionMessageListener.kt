package org.gitanimals.guild.infra

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.infra.event.UserContributionUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class GuildUpdateGuildContributionMessageListener(
    private val guildService: GuildService,
    private val objectMapper: ObjectMapper,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) : MessageListener {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        runCatching {
            objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                UserContributionUpdated::class.java,
            )
        }.onSuccess {
            updateGuildContributions(it)
        }.onFailure {
            logger.error("Cannot update guild contributions message: $message", it)
            throw it
        }
    }

    private fun updateGuildContributions(userContributionUpdated: UserContributionUpdated) {
        guildService.updateContribution(
            username = userContributionUpdated.username,
            contributions = userContributionUpdated.contributions,
        )
    }
}
