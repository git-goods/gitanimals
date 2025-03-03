package org.gitanimals.rank.app

import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.rank.domain.response.RankResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class GetRankByUsernameFacade(
    private val userContributionRankService: UserContributionRankService,
    private val rankQueryRepository: RankQueryRepository,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    fun invoke(username: String): RankResponse {
        val userContributionRank = userContributionRankService.findUserRankByUsername(username)

        logger.info("userContributionRank: ${userContributionRank?.username}")

        checkNotNull(userContributionRank) {
            "UserContributionRank is null username: $username"
        }

        val rankQueryResponse = rankQueryRepository.getRankByRankId(
            type = RankQueryRepository.Type.WEEKLY_USER_CONTRIBUTIONS,
            rankId = userContributionRank.id,
        )

        logger.info("rankQueryResponse: $rankQueryResponse")

        return RankResponse(
            rank = rankQueryResponse.rank,
            image = userContributionRank.image,
            name = userContributionRank.username,
            contributions = userContributionRank.weeklyContributions,
        )
    }
}
