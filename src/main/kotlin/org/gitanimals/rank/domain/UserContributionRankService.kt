package org.gitanimals.rank.domain

import org.gitanimals.rank.domain.event.RankUpdated
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
        runCatching {
            userContributionRankRepository.findByUserId(updateUserContributionRank.userId)
                ?: throw IllegalArgumentException("Cannot find UserContributionRank by userId: \"${updateUserContributionRank.userId}\"")
        }.recoverCatching {
            userContributionRankRepository.save(updateUserContributionRank)
        }.onSuccess {
            it.totalContributions = updateUserContributionRank.totalContributions
            eventPublisher.publishEvent(
                RankUpdated(
                    type = RankQueryRepository.Type.WEEKLY_USER_CONTRIBUTIONS,
                    rankId = RankId(it.id),
                    score = it.totalContributions,
                )
            )
        }.onFailure {
            logger.error(
                "Cannot update UserContributionRank by userId: \"${updateUserContributionRank.userId}\"", it
            )
        }
    }
}
