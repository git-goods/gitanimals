package org.gitanimals.rank.domain.history.request

import org.gitanimals.rank.domain.RankQueryRepository.RankType

data class InitRankHistoryRequest(
    val rank: Int,
    val prize: Int,
    val rankType: RankType,
    val winnerId: Long,
    val winnerName: String,
)
