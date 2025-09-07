package org.gitanimals.render.controller.response

import org.gitanimals.core.PersonaGrade
import org.gitanimals.core.PersonaType

data class PersonaEnumResponse(
    val type: PersonaType,
    val dropRate: String,
    val grade: PersonaGrade,
) {

    companion object {
        fun from(personaType: PersonaType): PersonaEnumResponse {
            return PersonaEnumResponse(
                type = personaType,
                dropRate = personaType.getDropRate(),
                grade = personaType.grade,
            )
        }
    }
}
