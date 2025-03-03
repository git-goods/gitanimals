package org.gitanimals.rank.domain

import jakarta.transaction.Transactional
import org.gitanimals.rank.domain.event.RankUpdated
import org.gitanimals.rank.domain.response.RankResponse
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class GuildContributionRankService(
    private val guildContributionRankRepository: GuildContributionRankRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {

    @Transactional
    fun updateContribution(updatedGuildContributionRank: GuildContributionRank) {
        val guildRank = runCatching {
            guildContributionRankRepository.findByGuildId(updatedGuildContributionRank.guildId)
                ?.also {
                    it.weeklyContributions += updatedGuildContributionRank.weeklyContributions
                }
                ?: throw IllegalArgumentException("Cannot find GuildContributionRank by guildId: \"${updatedGuildContributionRank.guildId}\"")
        }.getOrElse {
            guildContributionRankRepository.save(updatedGuildContributionRank)
        }

        eventPublisher.publishEvent(
            RankUpdated(
                type = RankQueryRepository.Type.WEEKLY_GUILD_CONTRIBUTIONS,
                rankId = RankId(guildRank.id),
                score = guildRank.weeklyContributions,
            )
        )
    }

    fun findAllByRankIds(rankWithId: Map<Int, Long>): List<RankResponse> {
        val rankIds = rankWithId.values
        val idWithRank = rankWithId.map { it.value to it.key }.toMap()

        return guildContributionRankRepository.findAllById(rankIds).map {
            RankResponse(
                rank = idWithRank[it.id]
                    ?: throw IllegalStateException("Cannot find rank value by id ${it.id}"),
                image = it.image,
                contributions = it.weeklyContributions,
                name = it.guildName,
            )
        }.sortedBy { it.rank }
    }

    fun initialWeeklyRanks() {
        guildContributionRankRepository.initialWeeklyRanks()
    }
}
