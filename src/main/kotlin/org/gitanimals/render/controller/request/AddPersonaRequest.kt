package org.gitanimals.render.controller.request

data class AddPersonaRequest(
    val id: Long,
    val name: String,
    val level: Int,
)
