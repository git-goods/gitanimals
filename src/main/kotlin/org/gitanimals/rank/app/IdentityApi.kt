package org.gitanimals.rank.app

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

fun interface IdentityApi {

    @GetExchange("/internals/users/by-name/{name}")
    fun getUserByName(@PathVariable("name") name: String): UserResponse

    data class UserResponse(
        val id: String,
        val username: String,
        val points: String,
        val profileImage: String,
    )

    private companion object {
        private const val INTERNAL_SECRET_KEY = "Internal-Secret"
    }
}
