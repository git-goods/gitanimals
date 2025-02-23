package org.gitanimals.rank.domain

interface RankQueryRepository {

    fun getRank(rankStartedAt: Int, type: Type, limit: Int): Set<RankId>

    fun updateRank(type: Type, rankId: RankId, score: Long)

    enum class Type {
        WEEKLY_GUILD_CONTRIBUTIONS,
        WEEKLY_USER_CONTRIBUTIONS,
        ;
    }

}

@JvmInline
value class RankId(val value: Long)
