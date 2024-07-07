package org.gitanimals.render.domain.event

data class NewUserCreated(
    val userId: Long,
    val username: String,
    val newUserCreated: Boolean = true,
)
