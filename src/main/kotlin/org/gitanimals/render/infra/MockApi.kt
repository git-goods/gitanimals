package org.gitanimals.render.infra

import org.gitanimals.render.app.Api
import org.gitanimals.render.domain.User
import org.springframework.stereotype.Component

@Component
class MockApi: Api {

    override fun createNewUser(user: User) {
        "createNewUser"
    }
}
