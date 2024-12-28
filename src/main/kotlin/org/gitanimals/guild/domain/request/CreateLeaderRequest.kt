package org.gitanimals.guild.domain.request

import org.gitanimals.core.PersonaType
import org.gitanimals.guild.domain.Leader

data class CreateLeaderRequest(
    val userId: Long,
    val name: String,
    val personaId: Long,
    val contributions: Long,
    val personaType: PersonaType,
) {

    fun toDomain(): Leader {
        return Leader(
            userId = userId,
            name = name,
            personaId = personaId,
            contributions = contributions,
            personaType = personaType,
        )
    }
}
