package org.gitanimals.guild.domain.extension

import org.gitanimals.core.FieldType

object GuildFieldTypeExtension {

    fun FieldType.isGuildField(): Boolean {
        return this in guildFields
    }

    private val guildFields = setOf(
        FieldType.FOLDER,
        FieldType.RED_COMPUTER,
        FieldType.RED_SOFA,
    )
}
