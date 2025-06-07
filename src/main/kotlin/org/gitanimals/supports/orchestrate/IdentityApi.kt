package org.gitanimals.supports.orchestrate

import org.gitanimals.core.auth.UserEntryPoint
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.PatchExchange

fun interface IdentityApi {

    @PatchExchange("/internals/users")
    fun updateUserByAuthInfo(
        @RequestParam("entry-point") entryPoint: UserEntryPoint,
        @RequestParam("authentication-id") authenticationId: String,
        @RequestBody request: UsernameUpdateRequest,
    )
}

data class UsernameUpdateRequest(
    val changedName: String,
)
