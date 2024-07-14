package org.gitanimals.render.controller.response

data class TotalPersonaResponse(
    private val personaCount: String,
) {

    companion object {
        fun from(totalPersonaCount: Long): TotalPersonaResponse =
            TotalPersonaResponse(totalPersonaCount.toString())
    }
}
