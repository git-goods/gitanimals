package org.gitanimals.guild.app.request

import org.gitanimals.core.FieldType

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
            require(it in acceptableTitle) { "Cannot accept title \"$it\"" }
        }
    }

    companion object {
        val acceptableTitle = run {
            val acceptableTitles = mutableListOf<Char>()
            for (i in 'A'..'Z') {
                acceptableTitles.add(i)
            }
            for (i in 'a'..'z') {
                acceptableTitles.add(i)
            }
            for (i in 0..9) {
                acceptableTitles.add(i.toChar())
            }
            acceptableTitles.add('-')
            acceptableTitles.toList()
        }
    }
}
