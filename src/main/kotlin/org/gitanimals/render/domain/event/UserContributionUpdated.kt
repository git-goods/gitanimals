package org.gitanimals.render.domain.event

import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.core.instant
import org.gitanimals.core.redis.RedisPubSubChannel
import org.gitanimals.core.redis.TransactionCommitRedisPubSubEvent
import java.time.Instant

data class UserContributionUpdated(
    val username: String,
    val contributions: Long,
    val updatedContributions: Long,
    val userContributionUpdated: Boolean = true,
    val contributionUpdatedAt: Instant = instant(),
) : TransactionCommitRedisPubSubEvent(
    channel = RedisPubSubChannel.USER_CONTRIBUTION_UPDATED,
    source = DomainEventPublisher::class,
)
