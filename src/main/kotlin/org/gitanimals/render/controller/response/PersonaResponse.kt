package org.gitanimals.render.controller.response

import org.gitanimals.core.PersonaType

data class PersonaResponse(
    val id: String,
    val type: PersonaType,
    val level: String,
    val visible: Boolean,
    val dropRate: String,
)
