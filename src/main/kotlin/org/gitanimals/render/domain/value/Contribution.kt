package org.gitanimals.render.domain.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.Instant

@Embeddable
class Contribution(
    @Column(name = "year", nullable = false)
    val year: Int,
    @Column(name = "contribution", nullable = false)
    var contribution: Int,
    @Column(name = "last_updated_contributions",)
    var lastUpdatedContribution: Instant,
)
