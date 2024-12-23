package org.gitanimals.render.domain.event

import org.gitanimals.render.core.clock
import java.time.Instant

data class PersonaDeleted(
    val userId: Long,
    val username: String,
    val personaId: Long,
    val personaDeletedAt: Instant = clock.instant(),
)
