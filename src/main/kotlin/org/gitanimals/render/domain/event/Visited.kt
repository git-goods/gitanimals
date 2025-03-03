package org.gitanimals.render.domain.event

data class Visited(
    val username: String,
    val traceId: String,
)
