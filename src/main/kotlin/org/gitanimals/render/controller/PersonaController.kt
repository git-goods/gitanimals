package org.gitanimals.render.controller

import org.gitanimals.render.app.UserFacade
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

    @PatchMapping("/personas")
    @ResponseStatus(HttpStatus.OK)
    fun changePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody personaChangeRequest: PersonaChangeRequest,
    ) = userFacade.changePersona(token, personaChangeRequest)
}
