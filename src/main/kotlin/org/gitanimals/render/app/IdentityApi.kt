package org.gitanimals.render.app

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange

interface IdentityApi {

    @GetExchange("/users")
    fun getUserByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): UserResponse

    @PostExchange("/internals/users/points/increases/by-username/{username}")
    fun increaseUserPointsByUsername(
        @PathVariable("username") username: String,
        @RequestParam("point") point: Int,
        @RequestParam("idempotency-key") idempotencyKey: String,
    )

    @GetExchange("/internals/users/{user-id}")
    fun getUserById(
        @PathVariable("user-id") userId: Long
    ): UserResponse

    data class UserResponse(
        val id: String,
        val username: String,
        val points: String,
        val profileImage: String,
    )
}
