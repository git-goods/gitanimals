package org.gitanimals.rank.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "rank")
class PersonaRank(
    id: Long,
    order: Long,

    @Column(name = "userId", nullable = false, unique = true)
    val userId: Long,
    @Column(name = "personaId", nullable = false, unique = true)
    val personaId: Long,
    @Column(name = "totalContributions", nullable = false)
    val totalContributions: Long,
) : Rank(id, order)
