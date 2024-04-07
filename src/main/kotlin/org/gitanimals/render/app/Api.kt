package org.gitanimals.render.app

import org.gitanimals.render.domain.User

fun interface Api {

    fun createNewUser(user: User)
}
