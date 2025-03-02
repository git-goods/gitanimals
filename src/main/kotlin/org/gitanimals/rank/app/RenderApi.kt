package org.gitanimals.rank.app

import org.gitanimals.core.PersonaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

fun interface RenderApi {

    @GetExchange("/internals/users/{username}/top-level-personas")
    fun getUserWithTopLevelPersona(@PathVariable("username") username: String): UserResponse

    data class UserResponse(
        val id: String,
        val name: String,
        val totalContributions: String,
        val personas: List<PersonaResponse>,
    )

    data class PersonaResponse(
        val id: String,
        val type: PersonaType,
        val level: String,
        val visible: Boolean,
        val dropRate: String,
    )
}
