package org.gitanimals.render.domain.response

import org.gitanimals.render.domain.Persona
import org.gitanimals.core.PersonaType

data class PersonaResponse(
    val id: String,
    val type: PersonaType,
    val level: String,
    val visible: Boolean,
    val appVisible: Boolean,
    val dropRate: String,
) {
    companion object {
        fun from(persona: Persona): PersonaResponse {
            return PersonaResponse(
                id = persona.id.toString(),
                type = persona.type,
                level = persona.level.value.toString(),
                visible = persona.visible,
                appVisible = persona.appVisible,
                dropRate = persona.type.getDropRate(),
            )
        }
    }
}
