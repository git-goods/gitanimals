package org.gitanimals.render.controller

import org.gitanimals.core.IdGenerator
import org.gitanimals.core.AuthorizationException
import org.gitanimals.render.app.UserFacade
import org.gitanimals.render.controller.request.AddMultiplyPersonaRequest
import org.gitanimals.render.controller.request.AddPersonaRequest
import org.gitanimals.render.controller.request.UsernameAndPersonaIdRequest
import org.gitanimals.core.ErrorResponse
import org.gitanimals.render.controller.response.PersonaResponse
import org.gitanimals.render.controller.response.UserResponse
import org.gitanimals.render.domain.UserService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class InternalPersonaController(
    private val userFacade: UserFacade,
    private val userService: UserService,
) {

    @PostMapping("/internals/personas")
    fun addPersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("idempotency-key") idempotencyKey: String,
        @RequestBody addPersonaRequest: AddPersonaRequest,
    ): PersonaResponse {
        val persona = userFacade.addPersona(
            token,
            idempotencyKey,
            addPersonaRequest.id,
            addPersonaRequest.name,
            addPersonaRequest.level,
        )

        return PersonaResponse(
            persona.id,
            persona.type,
            persona.level,
            persona.visible,
            persona.dropRate,
        )
    }

    @PostMapping("/internals/personas/multiply")
    fun addPersonaMultiple(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody addPersonaRequests: List<AddMultiplyPersonaRequest>,
    ): List<PersonaResponse> {
        return addPersonaRequests.map {
            val persona = userFacade.addPersona(
                token,
                it.idempotencyKey,
                IdGenerator.generate(),
                it.personaName,
                0,
            )

            PersonaResponse(
                persona.id,
                persona.type,
                persona.level,
                persona.visible,
                persona.dropRate,
            )
        }
    }

    @DeleteMapping("/internals/personas")
    fun deletePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("persona-id") personaId: Long,
    ): PersonaResponse {
        val persona = userFacade.deletePersona(token, personaId)

        return PersonaResponse(
            persona.id,
            persona.type,
            persona.level,
            persona.visible,
            persona.dropRate,
        )
    }

    @GetMapping("/internals/personas/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllPersonasByUserIdsAndPersonaIds(
        @RequestBody usernameAndPersonaIdRequests: List<UsernameAndPersonaIdRequest>
    ): List<UserResponse> {
        val users = userService.findAllUsersByNameWithContributions(
            usernameAndPersonaIdRequests.map { it.username }.toSet()
        )

        return users.map { user ->
            val personaId = usernameAndPersonaIdRequests.first { it.username == user.name }.personaId
            UserResponse.fromWithSpecificPersona(user, listOf(personaId))
        }
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse =
        ErrorResponse.from(exception)

    @ExceptionHandler(AuthorizationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthorizationException(exception: AuthorizationException): ErrorResponse =
        ErrorResponse.from(exception)
}
