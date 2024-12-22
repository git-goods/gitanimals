package org.gitanimals.guild.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Leader(
    @Column(name = "leader_id", nullable = false)
    val userId: Long,

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    val name: String,

    @Column(name = "persona_id", nullable = false)
    var personaId: Long,

    @Column(name = "contributions", nullable = false)
    var contributions: Long,
)
