package org.gitanimals.guild.saga.event

data class UserContributionUpdated(
    val username: String,
    val point: Long,
    val contributions: Int,
)
