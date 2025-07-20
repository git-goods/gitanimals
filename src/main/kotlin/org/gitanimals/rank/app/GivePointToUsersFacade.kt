package org.gitanimals.rank.app

import org.gitanimals.core.IdGenerator
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.RankType.WEEKLY_USER_CONTRIBUTIONS
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.rank.domain.history.RankHistoryService
import org.gitanimals.rank.domain.history.request.InitRankHistoryRequest
import org.gitanimals.rank.domain.response.RankResponse
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class GivePointToUsersFacade(
    private val identityApi: IdentityApi,
    private val rankQueryRepository: RankQueryRepository,
    private val userContributionRankService: UserContributionRankService,
    private val rankHistoryService: RankHistoryService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Scheduled(cron = "0 0 23 * * SUN")
    fun givePointToUsers() {
        runCatching {
            val userRankWithIds = rankQueryRepository.findAllRank(
                rankStartedAt = 0,
                limit = 2,
                rankType = WEEKLY_USER_CONTRIBUTIONS,
            ).associate { it.rank to it.id }

            val userRanks = userContributionRankService.findAllByRankIds(userRankWithIds)

            userRanks.forEach { rankResponse ->
                runCatching {
                    val point = getPoint(rankResponse)

                    identityApi.increaseUserPointsByUsername(
                        username = rankResponse.name,
                        point = point,
                        idempotencyKey = IdGenerator.generate().toString(),
                    )
                }.onFailure {
                    logger.error("Cannot give point to user. rank info: \"${rankResponse}\"", it)
                }
            }

            rankHistoryService.initTop3Rank(
                userRanks.map {
                    InitRankHistoryRequest(
                        rank = it.rank,
                        prize = getPoint(it),
                        rankType = RankQueryRepository.RankType.WEEKLY_USER_CONTRIBUTIONS,
                        winnerId = it.id.toLong(),
                        winnerName = it.name,
                    )
                }
            )
            userContributionRankService.initialWeeklyRanks()
            rankQueryRepository.initialRank(WEEKLY_USER_CONTRIBUTIONS)
        }.onFailure {
            logger.info("[GivePointToUsersFacade] Fail to awarded point. ${it.message}", it)
        }
    }

    private fun getPoint(rankResponse: RankResponse) = when (rankResponse.rank) {
        0 -> 10_000
        1 -> 5_000
        2 -> 3_000
        else -> 0
    }
}
