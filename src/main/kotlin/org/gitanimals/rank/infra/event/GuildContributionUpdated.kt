package org.gitanimals.rank.infra.event

data class GuildContributionUpdated(
    val guildId: Long,
    val guildTitle: String,
    val guildImage: String,
    val contributions: Long,
    val timestamp: Long,
)
