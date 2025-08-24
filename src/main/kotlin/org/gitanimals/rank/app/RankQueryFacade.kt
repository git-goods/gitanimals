package org.gitanimals.rank.app

import org.gitanimals.rank.domain.GuildContributionRankService
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.RankType.WEEKLY_GUILD_CONTRIBUTIONS
import org.gitanimals.rank.domain.RankQueryRepository.RankType.WEEKLY_USER_CONTRIBUTIONS
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.rank.domain.response.RankResponse
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import kotlin.math.max

@Component
class RankQueryFacade(
    private val rankQueryRepository: RankQueryRepository,
    private val guildContributionRankService: GuildContributionRankService,
    private val userContributionRankService: UserContributionRankService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    fun findAllRank(
        rank: Int,
        size: Int,
        rankType: RankQueryRepository.RankType,
    ): List<RankResponse> {
        require(size > 1) { "Size must be lager than 1. size: $size" }
        require(size <= 20) { "Maximum request size is 20. size: $size" }
        require(rank >= 0) { "Rank must be larger than 0. rank: $rank" }

        val rankWithIds = rankQueryRepository.findAllRank(
            rankStartedAt = rank - 1,
            limit = rank + size - 1,
            rankType = rankType
        ).associate { it.rank to it.id }

        return when (rankType) {
            WEEKLY_GUILD_CONTRIBUTIONS -> guildContributionRankService.findAllByRankIds(rankWithIds)
            WEEKLY_USER_CONTRIBUTIONS -> userContributionRankService.findAllByRankIds(rankWithIds)
        }.map { it.copy(rank = it.rank + 1, contributions = max(0, it.contributions)) }
    }

    @Cacheable(cacheNames = ["rankTotalCountCacheManager"], key = "#rankType")
    fun findRankTotalCountByRankType(
        rankType: RankQueryRepository.RankType,
    ): Int {
        return rankQueryRepository.getTotalRankCount(rankType)
    }
}
