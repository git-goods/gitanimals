package org.gitanimals.render.app

import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.request.PersonaChangeRequest
import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userService: UserService,
    private val identityApi: IdentityApi,
) {

    fun changePersona(token: String, personChangeRequest: PersonaChangeRequest) {
        val user = identityApi.getUserByToken(token)

        userService.changePersona(user.id.toLong(), personChangeRequest)
    }
}
