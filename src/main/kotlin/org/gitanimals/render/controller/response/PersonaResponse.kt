package org.gitanimals.render.controller.response

import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.response.PersonaResponse

data class PersonaResponse(
    val id: String,
    val type: PersonaType,
    val level: String,
    val visible: Boolean,
    val dropRate: String,
) {

    companion object {
        fun from(personaResponse: PersonaResponse): org.gitanimals.render.controller.response.PersonaResponse {
            return org.gitanimals.render.controller.response.PersonaResponse(
                id = personaResponse.id,
                type = personaResponse.type,
                level = personaResponse.level,
                visible = personaResponse.visible,
                dropRate = personaResponse.dropRate,
            )
        }
    }
}
