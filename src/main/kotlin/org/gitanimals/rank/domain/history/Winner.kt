package org.gitanimals.rank.domain.history

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Winner(
    @Column(name = "winner_id")
    val id: Long,
    @Column(name = "winner_name")
    val name: String,
)
