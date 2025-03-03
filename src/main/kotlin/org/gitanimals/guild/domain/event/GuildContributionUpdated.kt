package org.gitanimals.guild.domain.event

import org.gitanimals.core.redis.RedisPubSubChannel
import org.gitanimals.core.redis.TransactionCommitRedisPubSubEvent
import org.gitanimals.core.DomainEventPublisher

data class GuildContributionUpdated(
    val guildId: Long,
    val guildTitle: String,
    val guildImage: String,
    val contributions: Long,
    val updatedContributions: Long,
) : TransactionCommitRedisPubSubEvent(
    channel = RedisPubSubChannel.GUILD_CONTRIBUTION_UPDATED,
    source = DomainEventPublisher::class,
)
