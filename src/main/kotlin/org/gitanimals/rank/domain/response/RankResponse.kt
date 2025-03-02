package org.gitanimals.rank.domain.response

data class RankResponse(
    val rank: Int,
    val image: String,
    val name: String,
    val contributions: Long,
)
