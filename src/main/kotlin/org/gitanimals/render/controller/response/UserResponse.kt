package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.User

data class UserResponse(
    val id: String,
    val name: String,
    private val personas: List<PersonaResponse>,
) {

    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                user.id.toString(),
                user.name,
                user.personas.map {
                    PersonaResponse(
                        it.id.toString(),
                        it.type,
                        it.level().toString(),
                        it.visible,
                        it.type.getDropRate()
                    )
                }.toList()
            )
        }
    }
}
