package org.gitanimals.rank.domain.event

import org.gitanimals.rank.domain.RankId
import org.gitanimals.rank.domain.RankQueryRepository

data class RankUpdated(
    val type: RankQueryRepository.Type,
    val rankId: RankId,
    val score: Long,
)
