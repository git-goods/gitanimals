package org.gitanimals.render.domain.event

import org.gitanimals.core.clock
import java.time.Instant

data class PersonaDeleted(
    val userId: Long,
    val username: String,
    val personaId: Long,
    val personaDeletedAt: Instant = clock.instant(),
)
