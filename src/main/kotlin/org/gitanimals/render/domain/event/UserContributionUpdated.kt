package org.gitanimals.render.domain.event

import org.gitanimals.core.instant
import java.time.Instant

data class UserContributionUpdated(
    val username: String,
    val contributions: Long,
    val userContributionUpdated: Boolean = true,
    val contributionUpdatedAt: Instant = instant(),
)
