package org.gitanimals.render.controller

import org.gitanimals.core.AuthorizationException
import org.gitanimals.core.ErrorResponse
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.auth.RequiredUserEntryPoints
import org.gitanimals.core.auth.UserEntryPoint
import org.gitanimals.render.app.UserFacade
import org.gitanimals.render.controller.request.AddMultiplyPersonaRequest
import org.gitanimals.render.controller.request.AddPersonaRequest
import org.gitanimals.render.controller.request.UsernameAndPersonaIdRequest
import org.gitanimals.render.controller.response.PersonaResponse
import org.gitanimals.render.controller.response.UserResponse
import org.gitanimals.render.domain.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class InternalPersonaController(
    private val userFacade: UserFacade,
    private val userService: UserService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @PostMapping("/internals/personas")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
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
            id = persona.id,
            type = persona.type,
            level = persona.level,
            visible = persona.visible,
            appVisible = persona.appVisible,
            dropRate = persona.dropRate,
        )
    }

    @PostMapping("/internals/personas/multiply")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
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
                id = persona.id,
                type = persona.type,
                level = persona.level,
                visible = persona.visible,
                appVisible = persona.appVisible,
                dropRate = persona.dropRate,
            )
        }
    }

    @DeleteMapping("/internals/personas")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun deletePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("persona-id") personaId: Long,
    ): PersonaResponse {
        val persona = userFacade.deletePersona(token, personaId)

        return PersonaResponse(
            id = persona.id,
            type = persona.type,
            level = persona.level,
            visible = persona.visible,
            appVisible = persona.appVisible,
            dropRate = persona.dropRate,
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

        require(users.size == usernameAndPersonaIdRequests.size) {
            val message = "Failed to retrieve all users from the request."
            val retrievedUsers = users.map { it.getName() }
            val failedRetrieveUsers = usernameAndPersonaIdRequests.filter { request ->
                request.username !in retrievedUsers
            }
            logger.error("$message request: \"$usernameAndPersonaIdRequests\", failed retrieved users: \"$failedRetrieveUsers\"")
            message
        }

        return users.map { user ->
            val personaId =
                usernameAndPersonaIdRequests.first { it.username == user.getName() }.personaId
            UserResponse.fromWithSpecificPersona(user, listOf(personaId))
        }
    }

    @GetMapping("/internals/users/{username}/top-level-personas")
    fun getTopLevelPersonaByUserName(@PathVariable(value = "username") username: String): UserResponse =
        UserResponse.fromOnlyTopLevelPersona(userService.getUserByNameWithAllContributions(username))

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse =
        ErrorResponse.from(exception)

    @ExceptionHandler(AuthorizationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthorizationException(exception: AuthorizationException): ErrorResponse =
        ErrorResponse.from(exception)
}
