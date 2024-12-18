package org.gitanimals.render.domain

import org.gitanimals.render.core.IdGenerator
import org.gitanimals.render.domain.value.Contribution

fun user(
    id: Long = IdGenerator.generate(),
    name: String = "devxb",
    personas: MutableList<Persona> = mutableListOf(),
    contributions: MutableList<Contribution> = mutableListOf(),
    visit: Long = 0L,
): User {
    return User(
        id = id,
        name = name,
        personas = personas,
        contributions = contributions,
        visit = visit,
        version = 0L,
        lastPersonaGivePoint = 0,
    )
}
