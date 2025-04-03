package org.gitanimals.rank.domain.history

import jakarta.persistence.*
import org.gitanimals.rank.domain.AbstractTime
import org.gitanimals.rank.domain.RankQueryRepository.RankType

@Entity
@Table(name = "rank_history")
class RankHistory(
    @Id
    val id: Long,
    @Column(name = "ranks")
    val ranks: Int,
    @Column(name = "prize")
    val prize: Int,
    @Column(name = "rank_type")
    val rankType: RankType,
    @Embedded
    val winner: Winner,
) : AbstractTime()
