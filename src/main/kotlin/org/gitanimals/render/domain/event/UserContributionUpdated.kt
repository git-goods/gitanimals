package org.gitanimals.render.domain.event

import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter
import org.gitanimals.core.instant
import org.gitanimals.core.redis.RedisPubSubChannel
import org.gitanimals.core.redis.TransactionCommitRedisPubSubEvent
import org.slf4j.MDC
import java.time.Instant

data class UserContributionUpdated(
    val username: String,
    val contributions: Long,
    val updatedContributions: Long,
    val userContributionUpdated: Boolean = true,
    val contributionUpdatedAt: Instant = instant(),
) : TransactionCommitRedisPubSubEvent(
    traceId = runCatching { MDC.get(MDCFilter.TRACE_ID) }.getOrElse {
        IdGenerator.generate().toString()
    },
    channel = RedisPubSubChannel.USER_CONTRIBUTION_UPDATED,
    source = DomainEventPublisher::class,
)
