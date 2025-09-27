package org.gitanimals.render.controller.response

import org.gitanimals.core.PersonaGrade
import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.Persona
import org.gitanimals.render.domain.response.PersonaResponse

data class PersonaResponse(
    val id: String,
    val type: PersonaType,
    val level: String,
    val visible: Boolean,
    val appVisible: Boolean,
    val dropRate: String,
    val grade: PersonaGrade,
    val isEvolutionable: Boolean,
) {

    companion object {
        fun from(personaResponse: PersonaResponse): org.gitanimals.render.controller.response.PersonaResponse {
            return org.gitanimals.render.controller.response.PersonaResponse(
                id = personaResponse.id,
                type = personaResponse.type,
                level = personaResponse.level,
                visible = personaResponse.visible,
                appVisible = personaResponse.appVisible,
                dropRate = personaResponse.dropRate,
                grade = personaResponse.grade,
                isEvolutionable = personaResponse.isEvolutionable,
            )
        }

        fun from(persona: Persona): org.gitanimals.render.controller.response.PersonaResponse {
            return org.gitanimals.render.controller.response.PersonaResponse(
                id = persona.id.toString(),
                type = persona.getType(),
                level = persona.level().toString(),
                visible = persona.visible,
                appVisible = persona.appVisible,
                dropRate = persona.getType().getDropRate(),
                grade = persona.getType().grade,
                isEvolutionable = persona.isEvolutionable(),
            )
        }
    }
}
