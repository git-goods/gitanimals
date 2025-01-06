package org.gitanimals.guild.app

import org.gitanimals.core.PersonaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.GetExchange

interface RenderApi {

    @GetExchange("/users/{username}")
    fun getUserByName(@PathVariable("username") username: String): UserResponse

    @GetExchange("/internals/personas/all")
    fun getAllPersonasByUserIdsAndPersonaIds(
        @RequestHeader(INTERNAL_SECRET_KEY) internalSecret: String,
        @RequestBody usernameAndPersonaIdRequests: List<UsernameAndPersonaIdRequest>,
    ): List<UserResponse>

    data class UserResponse(
        val id: String,
        val name: String,
        val totalContributions: String,
        val personas: List<PersonaResponse>,
    ) {

        data class PersonaResponse(
            val id: String,
            val level: String,
            val type: PersonaType,
        )
    }

    data class UsernameAndPersonaIdRequest(
        val username: String,
        val personaId: Long,
    )

    private companion object {
        private const val INTERNAL_SECRET_KEY = "Internal-Secret"
    }
}
