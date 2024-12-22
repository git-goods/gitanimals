package org.gitanimals.guild.app.request

import org.gitanimals.guild.domain.GuildFarmType

data class CreateGuildRequest(
    val title: String,
    val body: String,
    val guildIcon: String,
    val autoJoin: Boolean,
    val farmType: GuildFarmType,
    val personaId: String,
)
