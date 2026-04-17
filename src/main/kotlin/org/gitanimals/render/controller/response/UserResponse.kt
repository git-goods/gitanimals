package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.User

data class UserResponse(
    val id: String,
    val name: String,
    val totalContributions: String,
    private val personas: List<PersonaResponse>,
) {

    companion object {
        fun of(user: User, filterAnimation: Boolean): UserResponse {
            return UserResponse(
                user.id.toString(),
                user.getName(),
                user.contributionCount().toString(),
                user.personas.mapNotNull {
                    if (filterAnimation && it.getType().haveAnimation.not()) {
                        return@mapNotNull null
                    }
                    PersonaResponse.from(it)
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
                }.map { PersonaResponse.from(it) }.toList()
            )
        }

        fun fromOnlyTopLevelPersona(user: User): UserResponse {
            return UserResponse(
                id = user.id.toString(),
                name = user.getName(),
                totalContributions = user.contributionCount().toString(),
                personas = listOf(user.personas
                    .maxBy { it.level() }
                    .let { PersonaResponse.from(it) }
                )
            )
        }
    }
}
