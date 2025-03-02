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

    fun findAllByRankIds(rankWithId: Map<Int, Long>): List<RankResponse> {
        val rankIds = rankWithId.values
        val idWithRank = rankWithId.map { it.value to it.key }.toMap()

        return userContributionRankRepository.findAllById(rankIds).map {
            RankResponse(
                rank = idWithRank[it.id]
                    ?: throw IllegalStateException("Cannot find rank value by id ${it.id}"),
                image = it.image,
                contributions = it.totalContributions,
                name = it.username,
            )
        }
    }

    fun findUserRankByUsername(username: String): UserContributionRank? =
        userContributionRankRepository.findByUsername(username)
}
