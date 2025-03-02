package org.gitanimals.rank.infra

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.rank.domain.GuildContributionRank
import org.gitanimals.rank.domain.GuildContributionRankService
import org.gitanimals.rank.infra.event.GuildContributionUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class RankUpdateGuildContributionMessageListener(
    private val objectMapper: ObjectMapper,
    private val guildContributionService: GuildContributionRankService,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) : MessageListener {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        runCatching {
            objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                GuildContributionUpdated::class.java,
            )
        }.onSuccess {
            val updatedGuildContributionRank = GuildContributionRank.create(
                image = it.guildImage,
                guildName = it.guildTitle,
                guildId = it.guildId,
                totalContributions = it.contributions,
            )

            guildContributionService.updateContribution(updatedGuildContributionRank)
        }.onFailure {
            logger.error("Cannot update guild contributions by message: $message", it)
            throw it
        }
    }
}
