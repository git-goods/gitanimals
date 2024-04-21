package org.gitanimals.render.domain.request

data class PersonaChangeRequest(
    val personaId: String,
    val visible: Boolean,
)
