package org.gitanimals.rank.infra

import org.gitanimals.rank.domain.RankId
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.RankQueryResponse
import org.gitanimals.rank.domain.RankQueryRepository.Type
import org.gitanimals.rank.domain.event.RankUpdated
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class RedisRankQueryRepository(
    @Qualifier("gitanimalsRedisTemplate") val redisTemplate: StringRedisTemplate,
) : RankQueryRepository {

    override fun findAllRank(
        rankStartedAt: Int,
        type: Type,
        limit: Int,
    ): Set<RankQueryResponse> {
        val keySets: Set<String>? = redisTemplate.opsForZSet()
            .reverseRange(
                type.name,
                rankStartedAt.toLong(),
                limit.toLong(),
            )

        checkNotNull(keySets) { "Rank data in redis is null. rankStartedAt: $rankStartedAt, type: $type, limit: $limit" }

        return keySets.withIndex()
            .map { RankQueryResponse(rank = rankStartedAt + it.index, id = it.value.toLong()) }
            .sortedBy { it.rank }
            .toSet()
    }

    override fun getRankByRankId(type: Type, rankId: Long): RankQueryResponse {
        val rank = redisTemplate.opsForZSet()
            .reverseRank(type.name, rankId)

        checkNotNull(rank) { "Rank data in redis is null. rankId: $rankId, type: $type" }

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
            type = rankUpdated.type,
            rankId = rankUpdated.rankId,
            score = rankUpdated.score,
        )
    }

    override fun updateRank(type: Type, rankId: RankId, score: Long) {
        redisTemplate.opsForZSet()
            .add(type.name, rankId.value.toString(), score.toDouble())
    }
}
