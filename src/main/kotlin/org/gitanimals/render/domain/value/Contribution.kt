package org.gitanimals.render.domain.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Contribution(
    @Column(name = "year", nullable = false)
    val year: Int,
    @Column(name = "contribution", nullable = false)
    val contribution: Int
)
