package org.gitanimals.guild.domain.request

import org.gitanimals.guild.domain.GuildFarmType

data class ChangeGuildRequest(
    val title: String,
    val body: String,
    val farmType: GuildFarmType,
    val guildIcon: String,
    val autoJoin: Boolean,
)
