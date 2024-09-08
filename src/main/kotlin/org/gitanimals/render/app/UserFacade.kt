package org.gitanimals.render.app

import org.gitanimals.render.app.request.MergePersonaRequest
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.request.PersonaChangeRequest
import org.gitanimals.render.domain.response.PersonaResponse
import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userService: UserService,
    private val identityApi: IdentityApi,
) {

    fun changePersona(token: String, personChangeRequest: PersonaChangeRequest): PersonaResponse {
        val user = identityApi.getUserByToken(token)

        return userService.changePersona(user.username, personChangeRequest)
    }

    fun addPersona(
        token: String,
        idempotencyKey: String,
        id: Long,
        personaType: String,
        level: Int,
    ): PersonaResponse {
        val user = identityApi.getUserByToken(token)

        return userService.addPersona(user.username, id, personaType, level, idempotencyKey)
    }

    fun deletePersona(token: String, personaId: Long): PersonaResponse {
        val user = identityApi.getUserByToken(token)

        return userService.deletePersona(user.username, personaId)
    }

    fun getPersona(token: String, personaId: Long): PersonaResponse {
        val user = identityApi.getUserByToken(token)

        return userService.getPersona(user.username, personaId)
    }

    fun mergePersona(token: String, request: MergePersonaRequest) {
        val user = identityApi.getUserByToken(token)

        return userService.mergePersona(
            user.id.toLong(),
            request.increasePersonaId.toLong(),
            request.deletePersonaId.toLong(),
        )
    }
}
