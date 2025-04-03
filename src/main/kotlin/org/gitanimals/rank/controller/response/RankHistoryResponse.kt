package org.gitanimals.rank.controller.response

import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.history.RankHistory

data class RankHistoryResponse(
    val winner: List<Result>
) {
    data class Result(
        val id: String,
        val name: String,
        val rank: Int,
        val prize: Int,
        val rankType: RankQueryRepository.RankType,
    )

    companion object {
        fun from(rankHistories: List<RankHistory>): RankHistoryResponse {
            return RankHistoryResponse(
                winner = rankHistories.map {
                    Result(
                        id = it.winner.id.toString(),
                        name = it.winner.name,
                        rank = it.ranks,
                        prize = it.prize,
                        rankType = it.rankType,
                    )
                }.sortedBy { it.rank }
            )
        }
    }
}
