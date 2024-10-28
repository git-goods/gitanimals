package org.gitanimals.render.controller.response

import org.gitanimals.render.domain.User

data class BackgroundResponse(
    val id: String,
    val name: String,
    val backgrounds: List<Background>,
) {

    data class Background(
        val type: String,
    )

    companion object {
        fun from(user: User): BackgroundResponse {
            return BackgroundResponse(
                id = user.id.toString(),
                name = user.name,
                backgrounds = user.fields.map { Background(it.fieldType.toString()) },
            )
        }
    }
}
