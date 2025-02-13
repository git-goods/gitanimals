package org.gitanimals.guild.app

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange

interface IdentityApi {

    @GetExchange("/users")
    fun getUserByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): UserResponse

    @PostExchange("/internals/users/points/decreases")
    fun decreasePoint(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestHeader(INTERNAL_SECRET_KEY) internalSecret: String,
        @RequestParam("idempotency-key") idempotencyKey: String,
        @RequestParam("point") point: String,
    )

    @PostExchange("/internals/users/points/increases")
    fun increasePoint(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestHeader(INTERNAL_SECRET_KEY) internalSecret: String,
        @RequestParam("idempotency-key") idempotencyKey: String,
        @RequestParam("point") point: String,
    )

    @GetExchange("/internals/users/by-name/{name}")
    fun getUserByName(
        @PathVariable("name") name: String,
        @RequestHeader(INTERNAL_SECRET_KEY) internalSecret: String,
    ): UserResponse

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
