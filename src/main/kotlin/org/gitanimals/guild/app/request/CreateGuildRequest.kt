package org.gitanimals.guild.app.request

import org.gitanimals.core.FieldType
import org.gitanimals.core.forbiddenWordsList
import org.gitanimals.core.largetTextAcceptableChars

data class CreateGuildRequest(
    val title: String,
    val body: String,
    val guildIcon: String,
    val autoJoin: Boolean,
    val farmType: FieldType,
    val personaId: String,
) {

    fun requireValidTitle() {
        title.forEach {
            require(it in largetTextAcceptableChars) { "Cannot accept title \"$it\"" }
        }

        require(forbiddenWordsList.none { title.contains(it, ignoreCase = true) }) {
            "Title contains forbidden word. title: \"$title\""
        }
    }
}
