package org.gitanimals.rank.domain.history

import org.gitanimals.rank.domain.RankQueryRepository.RankType
import org.springframework.data.jpa.repository.JpaRepository

interface RankHistoryRepository: JpaRepository<RankHistory, Long> {

    fun findTop3ByRankTypeOrderByCreatedAtDesc(rankType: RankType): List<RankHistory>
}
