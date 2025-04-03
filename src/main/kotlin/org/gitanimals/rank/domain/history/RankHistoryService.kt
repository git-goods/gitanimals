package org.gitanimals.rank.domain.history

import org.gitanimals.core.IdGenerator
import org.gitanimals.rank.domain.RankQueryRepository.RankType
import org.gitanimals.rank.domain.history.request.InitRankHistoryRequest
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RankHistoryService(
    private val rankHistoryRepository: RankHistoryRepository,
) {

    @Transactional
    fun initTop3Rank(
        initRankHistoryRequests: List<InitRankHistoryRequest>,
    ) {
        rankHistoryRepository.saveAll(initRankHistoryRequests.map {
            RankHistory(
                id = IdGenerator.generate(),
                ranks = it.rank,
                prize = it.prize,
                rankType = it.rankType,
                winner = Winner(
                    id = it.winnerId,
                    name = it.winnerName,
                )
            )
        })
    }

    @Cacheable(cacheNames = ["find_top3_history_by_rank_type"], )
    fun findTop3HistoryByRankType(rankType: RankType): List<RankHistory> {
        return rankHistoryRepository.findTop3ByRankTypeOrderByCreatedAtDesc(rankType)
            .sortedBy { it.ranks }
    }
}
