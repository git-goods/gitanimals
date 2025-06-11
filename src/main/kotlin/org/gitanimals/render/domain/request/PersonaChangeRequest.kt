package org.gitanimals.render.domain.request

data class PersonaChangeRequest(
    val personaId: String,
    val visible: Boolean,
    val type: VisibleChangeType = VisibleChangeType.DEFAULT
)

enum class VisibleChangeType {
    DEFAULT,
    APP,
    ;
}
