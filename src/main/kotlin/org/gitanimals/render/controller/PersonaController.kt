package org.gitanimals.render.controller

import org.gitanimals.render.controller.response.UserResponse
import org.gitanimals.render.domain.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonaController(
    private val userService: UserService
) {

    @GetMapping("/users/{username}")
    fun getUserByName(@PathVariable("username") username: String): UserResponse {
        return UserResponse.from(userService.getUserByName(username))
    }
}
