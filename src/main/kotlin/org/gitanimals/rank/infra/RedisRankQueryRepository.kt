package org.gitanimals.rank.infra

import org.gitanimals.rank.domain.RankId
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.RankQueryResponse
import org.gitanimals.rank.domain.event.RankUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class RedisRankQueryRepository(
    @Qualifier("gitanimalsRedisTemplate") val redisTemplate: StringRedisTemplate,
) : RankQueryRepository {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun findAllRank(
        rankStartedAt: Int,
        rankType: RankQueryRepository.RankType,
        limit: Int,
    ): Set<RankQueryResponse> {
        val keySets: Set<String>? = redisTemplate.opsForZSet()
            .reverseRange(
                rankType.name,
                rankStartedAt.toLong(),
                limit.toLong(),
            )

        logger.info("keySets: $keySets")

        checkNotNull(keySets) { "Rank data in redis is null. rankStartedAt: $rankStartedAt, type: $rankType, limit: $limit" }

        return keySets.withIndex()
            .map { RankQueryResponse(rank = rankStartedAt + it.index, id = it.value.toLong()) }
            .sortedBy { it.rank }
            .toSet()
    }

    override fun getRankByRankId(rankType: RankQueryRepository.RankType, rankId: Long): RankQueryResponse {
        val rank = redisTemplate.opsForZSet()
            .reverseRank(rankType.name, rankId.toString())

        checkNotNull(rank) { "Rank data in redis is null. rankId: $rankId, type: $rankType" }

        return RankQueryResponse(
            id = rankId,
            rank = rank.toInt(),
        )
    }

    @TransactionalEventListener(
        value = [RankUpdated::class],
        phase = TransactionPhase.AFTER_COMMIT,
    )
    fun handleUpdatedRankEvent(rankUpdated: RankUpdated) {
        updateRank(
            rankType = rankUpdated.type,
            rankId = rankUpdated.rankId,
            score = rankUpdated.score,
        )
    }

    override fun initialRank(rankType: RankQueryRepository.RankType) {
        redisTemplate.delete(rankType.name)
    }

    override fun updateRank(rankType: RankQueryRepository.RankType, rankId: RankId, score: Long) {
        redisTemplate.opsForZSet()
            .add(rankType.name, rankId.value.toString(), score.toDouble())
    }
}
