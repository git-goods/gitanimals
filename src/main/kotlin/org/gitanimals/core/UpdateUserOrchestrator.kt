package org.gitanimals.core

import org.gitanimals.core.auth.UserEntryPoint

fun interface UpdateUserOrchestrator {

    fun updateUsername(request: UpdateUserNameRequest)

    data class UpdateUserNameRequest(
        val id: Long,
        val authenticationId: String,
        val entryPoint: UserEntryPoint,
        val previousName: String,
        val changeName: String,
    )
}
