package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.User

data class UserResponse(
    val id: String,
    val name: String,
    val totalContributions: String,
    private val personas: List<PersonaResponse>,
) {

    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                user.id.toString(),
                user.getName(),
                user.contributionCount().toString(),
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

        fun fromWithSpecificPersona(user: User, personaId: List<Long>): UserResponse {
            return UserResponse(
                user.id.toString(),
                user.getName(),
                user.contributionCount().toString(),
                user.personas.filter {
                    it.id in personaId
                }.map {
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

        fun fromOnlyTopLevelPersona(user: User): UserResponse {
            return UserResponse(
                id = user.id.toString(),
                name = user.getName(),
                totalContributions = user.contributionCount().toString(),
                personas = listOf(user.personas
                    .maxBy { it.level() }
                    .let {
                        PersonaResponse(
                            it.id.toString(),
                            it.type,
                            it.level().toString(),
                            it.visible,
                            it.type.getDropRate()
                        )
                    }
                )
            )
        }
    }
}
