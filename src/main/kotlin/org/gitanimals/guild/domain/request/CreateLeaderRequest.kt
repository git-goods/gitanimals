package org.gitanimals.guild.domain.request

import org.gitanimals.guild.domain.Leader

data class CreateLeaderRequest(
    val userId: Long,
    val name: String,
    val personaId: Long,
    val contributions: Long,
) {

    fun toDomain(): Leader {
        return Leader(
            userId = userId,
            name = name,
            personaId = personaId,
            contributions = contributions,
        )
    }
}
