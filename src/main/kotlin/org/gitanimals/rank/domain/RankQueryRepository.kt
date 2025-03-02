package org.gitanimals.rank.domain

interface RankQueryRepository {

    fun findAllRank(rankStartedAt: Int, type: Type, limit: Int): Set<RankQueryResponse>

    fun getRankByRankId(type: Type, rankId: Long): RankQueryResponse

    fun updateRank(type: Type, rankId: RankId, score: Long)

    enum class Type {
        WEEKLY_GUILD_CONTRIBUTIONS,
        WEEKLY_USER_CONTRIBUTIONS,
        ;
    }

    data class RankQueryResponse(
        val id: Long,
        val rank: Int,
    )

}

@JvmInline
value class RankId(val value: Long)
