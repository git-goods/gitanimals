package org.gitanimals.guild.app

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

fun interface RenderApi {

    @GetExchange("/users/{username}")
    fun getUserByName(@PathVariable("username") username: String): UserResponse

    data class UserResponse(
        val id: String,
        val name: String,
        val totalContributions: String,
        val personas: List<PersonaResponse>,
    ) {

        data class PersonaResponse(
            val id: String,
            val level: String,
        )
    }
}
