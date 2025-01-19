package org.gitanimals.guild.saga.event

import java.time.Instant

data class UserContributionUpdated(
    val username: String,
    val contributions: Long,
    val userContributionUpdated: Boolean,
    val contributionUpdatedAt: Instant,
)
