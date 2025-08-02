package org.gitanimals.rank.infra.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.core.redis.TraceableMessageListener
import org.gitanimals.rank.domain.GuildContributionRank
import org.gitanimals.rank.domain.GuildContributionRankService
import org.gitanimals.rank.infra.event.GuildContributionUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class RankUpdateGuildContributionMessageListener(
    private val objectMapper: ObjectMapper,
    private val guildContributionService: GuildContributionRankService,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) : TraceableMessageListener(
    listenerName = "RankUpdateGuildContributionMessageListener",
    objectMapper = objectMapper,
    redisTemplate = redisTemplate,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message) {
        runCatching {
            val guildContributionUpdated = objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                GuildContributionUpdated::class.java,
            )

            val updatedGuildContributionRank = GuildContributionRank.create(
                image = guildContributionUpdated.guildImage,
                guildName = guildContributionUpdated.guildTitle,
                guildId = guildContributionUpdated.guildId,
                weeklyContributions = guildContributionUpdated.updatedContributions,
            )

            guildContributionService.updateContribution(updatedGuildContributionRank)
        }.onFailure {
            logger.error("Cannot update guild contributions by message: $message", it)
            throw it
        }
    }
}
