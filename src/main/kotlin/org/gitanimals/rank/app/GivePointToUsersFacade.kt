package org.gitanimals.rank.app

import org.gitanimals.core.IdGenerator
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.Type.WEEKLY_USER_CONTRIBUTIONS
import org.gitanimals.rank.domain.UserContributionRankService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class GivePointToUsersFacade(
    private val identityApi: IdentityApi,
    private val rankQueryRepository: RankQueryRepository,
    private val userContributionRankService: UserContributionRankService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Scheduled(cron = "0 0 23 * * SUN")
    fun givePointToUsers() {
        val userRankWithIds = rankQueryRepository.findAllRank(
            rankStartedAt = 0,
            limit = 2,
            type = WEEKLY_USER_CONTRIBUTIONS,
        ).associate { it.rank to it.id }

        val userRanks = userContributionRankService.findAllByRankIds(userRankWithIds)

        userRanks.forEach { rankResponse ->
            runCatching {
                val point = when {
                    rankResponse.rank == 0 -> 10_000
                    rankResponse.rank == 1 -> 5_000
                    rankResponse.rank == 2 -> 3_000
                    else -> 0
                }

                identityApi.increaseUserPointsByUserId(
                    username = rankResponse.name,
                    point = point,
                    idempotencyKey = IdGenerator.generate().toString(),
                )
            }.onFailure {
                logger.error("Cannot give point to user. rank info: \"${rankResponse}\"", it)
            }
        }

        userContributionRankService.initialWeeklyRanks()
        rankQueryRepository.initialRank(WEEKLY_USER_CONTRIBUTIONS)
    }
}
