package org.gitanimals.guild.domain.request

import org.gitanimals.core.FieldType
import org.gitanimals.core.largetTextAcceptableChars

data class ChangeGuildRequest(
    val title: String,
    val body: String,
    val farmType: FieldType,
    val guildIcon: String,
    val autoJoin: Boolean,
) {

    fun requireValidTitle() {
        title.forEach {
            require(it in largetTextAcceptableChars) { "Cannot accept title \"$it\"" }
        }
    }
}
