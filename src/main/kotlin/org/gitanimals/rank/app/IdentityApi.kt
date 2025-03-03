package org.gitanimals.rank.app

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange

interface IdentityApi {

    @GetExchange("/internals/users/by-name/{name}")
    fun getUserByName(@PathVariable("name") name: String): UserResponse

    @PostExchange("/internals/users/points/increases/by-username/{username}")
    fun increaseUserPointsByUserId(
        @PathVariable("username") username: String,
        @RequestParam("point") point: Int,
        @RequestParam("idempotency-key") idempotencyKey: String,
    )

    data class UserResponse(
        val id: String,
        val username: String,
        val points: String,
        val profileImage: String,
    )
}
