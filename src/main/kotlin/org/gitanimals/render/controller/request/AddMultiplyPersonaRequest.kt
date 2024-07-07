package org.gitanimals.render.controller.request

data class AddMultiplyPersonaRequest(
    val idempotencyKey: String,
    val personaName: String,
)
