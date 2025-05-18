package org.gitanimals.core

fun interface CreateUserOrchestrator {

    fun create(request: CreateUserRequest)

    data class CreateUserRequest(
        val username: String,
    )
}
