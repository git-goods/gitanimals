package org.gitanimals.guild.domain.event

import org.gitanimals.core.DomainEventPublisher
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter
import org.gitanimals.core.redis.RedisPubSubChannel
import org.gitanimals.core.redis.TransactionCommitRedisPubSubEvent
import org.slf4j.MDC

data class GuildContributionUpdated(
    val guildId: Long,
    val guildTitle: String,
    val guildImage: String,
    val contributions: Long,
    val updatedContributions: Long,
) : TransactionCommitRedisPubSubEvent(
    traceId = runCatching { MDC.get(MDCFilter.TRACE_ID) }.getOrElse {
        IdGenerator.generate().toString()
    },
    channel = RedisPubSubChannel.GUILD_CONTRIBUTION_UPDATED,
    source = DomainEventPublisher::class,
)
