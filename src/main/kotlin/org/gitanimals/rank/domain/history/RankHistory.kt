package org.gitanimals.rank.domain.history

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.gitanimals.rank.domain.AbstractTime
import org.gitanimals.rank.domain.RankQueryRepository.RankType

@Entity
@Table(name = "rank_history")
class RankHistory(
    @Id
    val id: Long,
    @Column(name = "rank")
    val rank: Int,
    @Column(name = "prize")
    val prize: Int,
    @Column(name = "rank_type")
    val rankType: RankType,
) : AbstractTime()
