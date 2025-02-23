package org.gitanimals.rank.infra

import org.gitanimals.rank.domain.RankId
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.Type
import org.gitanimals.rank.domain.event.RankUpdated
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

class RedisRankQueryRepository(
    @Qualifier("gitanimalsRedisTemplate") val redisTemplate: StringRedisTemplate,
) : RankQueryRepository {

    override fun getRank(
        rankStartedAt: Int,
        type: Type,
        limit: Int,
    ): Set<RankId> {
        val keySets: Set<String>? = redisTemplate.opsForZSet()
            .reverseRange(
                type.name,
                rankStartedAt.toLong(),
                limit.toLong(),
            )

        checkNotNull(keySets) { "Rank data in redis is null" }

        return keySets.map { RankId(it.toLong()) }.toSet()
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
