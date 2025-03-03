package org.gitanimals.rank.domain

import jakarta.transaction.Transactional
import org.gitanimals.rank.domain.event.RankUpdated
import org.gitanimals.rank.domain.response.RankResponse
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class GuildContributionRankService(
    private val guildContributionRankRepository: GuildContributionRankRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Transactional
    fun updateContribution(updatedGuildContributionRank: GuildContributionRank) {
        runCatching {
            guildContributionRankRepository.findByGuildId(updatedGuildContributionRank.guildId)
                ?: throw IllegalArgumentException("Cannot find GuildContributionRank by guildId: \"${updatedGuildContributionRank.guildId}\"")
        }.recoverCatching {
            guildContributionRankRepository.save(updatedGuildContributionRank)
        }.onSuccess {
            it.totalContributions = updatedGuildContributionRank.totalContributions
            eventPublisher.publishEvent(
                RankUpdated(
                    type = RankQueryRepository.Type.WEEKLY_GUILD_CONTRIBUTIONS,
                    rankId = RankId(it.id),
                    score = it.totalContributions,
                )
            )
        }.onFailure {
            logger.error(
                "Cannot update GuildContributionRank by guildId: \"${updatedGuildContributionRank.guildId}\"", it
            )
        }
    }

    fun findAllByRankIds(rankWithId: Map<Int, Long>): List<RankResponse> {
        val rankIds = rankWithId.values
        val idWithRank = rankWithId.map { it.value to it.key }.toMap()

        return guildContributionRankRepository.findAllById(rankIds).map {
            RankResponse(
                rank = idWithRank[it.id]
                    ?: throw IllegalStateException("Cannot find rank value by id ${it.id}"),
                image = it.image,
                contributions = it.totalContributions,
                name = it.guildName,
            )
        }.sortedBy { it.rank }
    }
}
