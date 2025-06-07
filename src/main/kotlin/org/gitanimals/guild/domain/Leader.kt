package org.gitanimals.guild.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.gitanimals.core.PersonaType

@Embeddable
data class Leader(
    @Column(name = "leader_id", nullable = false)
    val userId: Long,

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255)")
    var name: String,

    @Column(name = "persona_id", nullable = false)
    var personaId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "persona_type", nullable = false, columnDefinition = "VARCHAR(255)")
    var personaType: PersonaType,

    @Column(name = "contributions", nullable = false)
    var contributions: Long,
)
