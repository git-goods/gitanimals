package org.gitanimals.rank.app

import org.gitanimals.rank.domain.UserContributionRank
import org.gitanimals.rank.domain.UserContributionRankService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

@Component
class UpdateUserContributionFacade(
    private val identityApi: IdentityApi,
    private val rankContributionApi: RankContributionApi,
    private val userContributionRankService: UserContributionRankService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    fun updateUserWeeklyContributions(username: String) {
        val user = runCatching {
            identityApi.getUserByName(username)
        }.getOrElse {
            if (it is IllegalArgumentException) {
                logger.info("[UpdateUserContributionFacade] ignore updateUserWeeklyContributions cause its not identity user. username: $username")
                return
            }
            throw it
        }

        val from = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1)
        val to = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7)

        val weeklyContributions = rankContributionApi.getContributionsBySpecificDays(
            username = username,
            from = from,
            to = to,
        )
        logger.info("[UpdateUserContributionFacade] from: $from, to: $to, weeklyContributions: $weeklyContributions")

        val updatedUserContributionRank = UserContributionRank.create(
            image = user.profileImage,
            userId = user.id.toLong(),
            username = user.username,
            weeklyContributions = weeklyContributions.toLong(),
        )

        userContributionRankService.updateContribution(updatedUserContributionRank)
        logger.info("[UpdateUserContributionFacade] update user weekly contributions. username: \"$username\", updated contributions: $weeklyContributions")
    }
}
