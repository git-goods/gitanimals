package org.gitanimals.render.domain.event

data class UsernameChanged(
    val previousName: String,
    val changedName: String,
)
