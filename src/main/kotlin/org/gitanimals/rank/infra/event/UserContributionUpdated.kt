package org.gitanimals.rank.infra.event

import java.time.Instant

data class UserContributionUpdated(
    val traceId: String,
    val username: String,
    val contributions: Long,
    val updatedContributions: Long,
    val userContributionUpdated: Boolean,
    val contributionUpdatedAt: Instant,
    val timestamp: Long,
)
