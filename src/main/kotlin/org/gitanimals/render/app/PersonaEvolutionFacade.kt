package org.gitanimals.render.app

import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.response.PersonaResponse
import org.springframework.stereotype.Service

@Service
class PersonaEvolutionFacade(
    private val identityApi: IdentityApi,
    private val userService: UserService,
) {

    fun evolutionPersona(token: String, personaId: Long): PersonaResponse {
        val user = identityApi.getUserByToken(token)

        return userService.evolutionPersona(
            name = user.username,
            personaId = personaId,
        )
    }

    fun isEvoluationable(token: String, personaId: Long): Boolean {
        val user = identityApi.getUserByToken(token)

        return userService.isEvoluationable(
            name = user.username,
            personaId = personaId,
        )
    }
}
