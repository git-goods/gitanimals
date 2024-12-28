package org.gitanimals.guild.domain.request

import org.gitanimals.core.FieldType

data class ChangeGuildRequest(
    val title: String,
    val body: String,
    val farmType: FieldType,
    val guildIcon: String,
    val autoJoin: Boolean,
)
