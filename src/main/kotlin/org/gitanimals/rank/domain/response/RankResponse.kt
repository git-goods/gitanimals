package org.gitanimals.rank.domain.response

data class RankResponse(
    val id: String,
    val rank: Int,
    val image: String,
    val name: String,
    val contributions: Long,
)
