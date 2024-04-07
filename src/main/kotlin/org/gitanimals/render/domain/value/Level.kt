package org.gitanimals.render.domain.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable


@Embeddable
data class Level(
    @Column(name = "level", nullable = false)
    val value: Long,
    @Column(name = "exp", nullable = false)
    val exp: Long,
)
