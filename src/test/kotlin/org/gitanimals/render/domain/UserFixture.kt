package org.gitanimals.render.domain

import org.gitanimals.render.domain.value.Contribution

fun user(
    id: Long = 0L,
    name: String = "devxb",
    personas: MutableList<Persona> = mutableListOf(),
    contributions: MutableList<Contribution> = mutableListOf(),
    visit: Long = 0L,
    field: FieldType = FieldType.WHITE_FIELD,
): User {
    return User(
        id = id,
        name = name,
        personas = personas,
        contributions = contributions,
        visit = visit,
        field = field,
        version = 0L,
        lastPersonaGivePoint = 0,
    )
}
