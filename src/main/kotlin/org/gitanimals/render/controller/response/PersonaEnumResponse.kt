package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.PersonaType

data class PersonaEnumResponse(
    val type: PersonaType,
    val dropRate: String,
) {

    companion object {
        fun from(personaType: PersonaType): PersonaEnumResponse {
            return PersonaEnumResponse(personaType, personaType.getDropRate())
        }
    }
}
