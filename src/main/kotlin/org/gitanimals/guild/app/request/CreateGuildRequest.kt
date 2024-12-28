package org.gitanimals.guild.app.request

import org.gitanimals.core.FieldType

data class CreateGuildRequest(
    val title: String,
    val body: String,
    val guildIcon: String,
    val autoJoin: Boolean,
    val farmType: FieldType,
    val personaId: String,
)
