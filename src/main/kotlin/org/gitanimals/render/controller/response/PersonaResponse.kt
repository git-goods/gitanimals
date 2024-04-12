package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.PersonaType

data class PersonaResponse(
    val id: String,
    val type: PersonaType,
    val level: String,
)
