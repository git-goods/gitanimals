package org.gitanimals.render.controller

import org.gitanimals.render.app.UserFacade
import org.gitanimals.render.controller.request.AddPersonaRequest
import org.gitanimals.render.controller.response.ErrorResponse
import org.gitanimals.render.controller.response.PersonaResponse
import org.gitanimals.render.controller.response.UserResponse
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.request.PersonaChangeRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class PersonaController(
    private val userService: UserService,
    private val userFacade: UserFacade,
) {

    @GetMapping("/users/{username}")
    fun getUserByName(@PathVariable("username") username: String): UserResponse {
        return UserResponse.from(userService.getUserByName(username))
    }

    @GetMapping("/personas/{persona-id}")
    fun getPersonaById(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("persona-id") personaId: Long,
    ): PersonaResponse {
        val persona = userFacade.getPersona(token, personaId)

        return PersonaResponse(persona.id, persona.type, persona.level, persona.visible)
    }

    @PatchMapping("/personas")
    @ResponseStatus(HttpStatus.OK)
    fun changePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody personaChangeRequest: PersonaChangeRequest,
    ): PersonaResponse {
        val changedPersona = userFacade.changePersona(token, personaChangeRequest)

        return PersonaResponse(
            changedPersona.id,
            changedPersona.type,
            changedPersona.level,
            changedPersona.visible,
        )
    }

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

        return PersonaResponse(persona.id, persona.type, persona.level, persona.visible)
    }

    @DeleteMapping("/internals/personas")
    fun deletePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("persona-id") personaId: Long,
    ): PersonaResponse {
        val persona = userFacade.deletePersona(token, personaId)

        return PersonaResponse(persona.id, persona.type, persona.level, persona.visible)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse =
        ErrorResponse.from(exception)
}
