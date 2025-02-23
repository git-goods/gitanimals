package org.gitanimals.rank.infra

import java.time.Instant

data class UserContributionUpdated(
    val username: String,
    val contributions: Long,
    val userContributionUpdated: Boolean,
    val contributionUpdatedAt: Instant,
)
