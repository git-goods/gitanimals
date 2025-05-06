package org.gitanimals.render.controller

import org.gitanimals.core.PersonaType
import org.gitanimals.core.AuthorizationException
import org.gitanimals.render.app.UserFacade
import org.gitanimals.render.app.request.MergePersonaRequest
import org.gitanimals.core.ErrorResponse
import org.gitanimals.core.auth.RequiredUserEntryPoints
import org.gitanimals.core.auth.UserEntryPoint
import org.gitanimals.render.controller.response.PersonaEnumResponse
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
        return UserResponse.from(userService.getUserByNameWithAllContributions(username))
    }

    @GetMapping("/personas/{persona-id}")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun getPersonaById(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("persona-id") personaId: Long,
    ): PersonaResponse {
        val persona = userFacade.getPersona(token, personaId)

        return PersonaResponse(
            persona.id,
            persona.type,
            persona.level,
            persona.visible,
            persona.dropRate
        )
    }

    @PatchMapping("/personas")
    @ResponseStatus(HttpStatus.OK)
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
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
            changedPersona.dropRate,
        )
    }

    @GetMapping("/personas/infos")
    @ResponseStatus(HttpStatus.OK)
    fun getAllPersonaInfo(): Map<String, List<PersonaEnumResponse>> {
        return mapOf(
            "personas" to PersonaType.entries
                .sortedByDescending { it.weight }
                .asSequence()
                .map { PersonaEnumResponse.from(it) }
                .toList()
        )
    }

    @PutMapping("/personas/merges")
    @ResponseStatus(HttpStatus.OK)
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun mergePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody meregPersonaRequest: MergePersonaRequest,
    ) = userFacade.mergePersona(token, meregPersonaRequest)

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse =
        ErrorResponse.from(exception)

    @ExceptionHandler(AuthorizationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthorizationException(exception: AuthorizationException): ErrorResponse =
        ErrorResponse.from(exception)
}
