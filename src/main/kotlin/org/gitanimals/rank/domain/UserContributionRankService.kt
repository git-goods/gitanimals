package org.gitanimals.rank.domain

import org.gitanimals.rank.domain.event.RankUpdated
import org.gitanimals.rank.domain.response.RankResponse
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserContributionRankService(
    private val eventPublisher: ApplicationEventPublisher,
    private val userContributionRankRepository: UserContributionRankRepository,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Transactional
    fun updateContribution(updateUserContributionRank: UserContributionRank) {
        val userRank = runCatching {
            userContributionRankRepository.findByUserId(updateUserContributionRank.userId)?.also {
                it.weeklyContributions += updateUserContributionRank.weeklyContributions
            }
                ?: throw IllegalArgumentException("Cannot find UserContributionRank by userId: \"${updateUserContributionRank.userId}\"")
        }.getOrElse {
            userContributionRankRepository.save(updateUserContributionRank)
        }

        eventPublisher.publishEvent(
            RankUpdated(
                type = RankQueryRepository.RankType.WEEKLY_USER_CONTRIBUTIONS,
                rankId = RankId(userRank.id),
                score = userRank.weeklyContributions,
            )
        )
    }

    fun findAllByRankIds(rankWithId: Map<Int, Long>): List<RankResponse> {
        val rankIds = rankWithId.values.toList()
        logger.info("rankIds: $rankIds")
        val idWithRank = rankWithId.map { it.value to it.key }.toMap()

        return userContributionRankRepository.findAllById(rankIds).map {
            RankResponse(
                id = it.userId.toString(),
                rank = idWithRank[it.id]
                    ?: throw IllegalStateException("Cannot find rank value by id ${it.id}"),
                image = it.image,
                contributions = it.weeklyContributions,
                name = it.username,
            )
        }.sortedBy { it.rank }
    }

    @Transactional
    fun updateUserRankUsernameIfExists(previousName: String, changeName: String) {
        findUserRankByUsername(previousName)?.let {
            it.username = changeName
        }
    }

    fun findUserRankByUsername(username: String): UserContributionRank? =
        userContributionRankRepository.findByUsername(username)

    @Transactional
    fun initialWeeklyRanks() {
        userContributionRankRepository.initialWeeklyRanks()
    }
}
