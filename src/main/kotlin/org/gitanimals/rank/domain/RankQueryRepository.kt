package org.gitanimals.rank.domain

interface RankQueryRepository {

    fun findAllRank(rankStartedAt: Int, rankType: RankType, limit: Int): Set<RankQueryResponse>

    fun getRankByRankId(rankType: RankType, rankId: Long): RankQueryResponse

    fun updateRank(rankType: RankType, rankId: RankId, score: Long)

    fun initialRank(rankType: RankType)

    enum class RankType {
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
