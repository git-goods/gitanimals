package org.gitanimals.rank.app

import org.gitanimals.rank.domain.response.RankResponse
import org.gitanimals.rank.domain.GuildContributionRankService
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.Type.WEEKLY_GUILD_CONTRIBUTIONS
import org.gitanimals.rank.domain.RankQueryRepository.Type.WEEKLY_USER_CONTRIBUTIONS
import org.springframework.stereotype.Component

@Component
class RankQueryFacade(
    private val rankQueryRepository: RankQueryRepository,
    private val guildContributionRankService: GuildContributionRankService,
    private val userContributionRankService: GuildContributionRankService,
) {

    fun findAllRank(
        rank: Int,
        size: Int,
        type: RankQueryRepository.Type,
    ): List<RankResponse> {
        val rankWithIds = rankQueryRepository.findAllRank(rankStartedAt = rank, limit = size, type = type).map { it.rank to it.id }.toMap()
        return when(type) {
            WEEKLY_GUILD_CONTRIBUTIONS -> guildContributionRankService.findAllByRankIds(rankWithIds)
            WEEKLY_USER_CONTRIBUTIONS -> userContributionRankService.findAllByRankIds(rankWithIds)
        }
    }
}
