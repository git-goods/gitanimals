package org.gitanimals.guild.domain.extension

import org.gitanimals.core.FieldType

object GuildFieldTypeExtension {

    fun FieldType.isGuildField(): Boolean {
        return this in guildFields
    }

    private val guildFields = listOf(FieldType.LOGO_SHOWING)
}
