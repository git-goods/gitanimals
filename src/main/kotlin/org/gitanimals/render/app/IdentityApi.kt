package org.gitanimals.render.app

fun interface IdentityApi {

    fun getUserByToken(token: String): UserResponse

    data class UserResponse(
        val id: String,
        val username: String,
        val points: String,
        val profileImage: String,
    )
}
