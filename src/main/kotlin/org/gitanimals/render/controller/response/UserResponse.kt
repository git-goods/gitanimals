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
                        id = it.id.toString(),
                        type = it.type,
                        level = it.level().toString(),
                        visible = it.visible,
                        appVisible = it.appVisible,
                        dropRate = it.type.getDropRate(),
                        grade = it.type.grade,
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
                        id = it.id.toString(),
                        type = it.type,
                        level = it.level().toString(),
                        visible = it.visible,
                        appVisible = it.appVisible,
                        dropRate = it.type.getDropRate(),
                        grade = it.type.grade,
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
                            id = it.id.toString(),
                            type = it.type,
                            level = it.level().toString(),
                            visible = it.visible,
                            appVisible = it.appVisible,
                            dropRate = it.type.getDropRate(),
                            grade = it.type.grade,
                        )
                    }
                )
            )
        }
    }
}
