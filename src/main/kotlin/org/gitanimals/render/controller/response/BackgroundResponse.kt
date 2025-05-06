package org.gitanimals.render.controller.response

import org.gitanimals.core.FieldType
import org.gitanimals.render.domain.User

data class BackgroundResponse(
    val id: String,
    val name: String,
    val backgrounds: List<Background>,
) {

    data class Background(
        val type: FieldType,
    )

    companion object {
        fun from(user: User): BackgroundResponse {
            return BackgroundResponse(
                id = user.id.toString(),
                name = user.getName(),
                backgrounds = user.fields.map { Background(it.fieldType) }.ifEmpty {
                    listOf(Background(FieldType.WHITE_FIELD))
                },
            )
        }
    }
}
