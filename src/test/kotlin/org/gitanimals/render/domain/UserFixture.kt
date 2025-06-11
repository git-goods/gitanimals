package org.gitanimals.render.domain

import org.gitanimals.core.IdGenerator
import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.value.Contribution
import org.gitanimals.render.domain.value.Level

fun user(
    id: Long = IdGenerator.generate(),
    name: String = "devxb",
    personas: MutableList<Persona> = mutableListOf(),
    contributions: MutableList<Contribution> = mutableListOf(),
    authInfo: UserAuthInfo? = UserAuthInfo(EntryPoint.GITHUB, id.toString()),
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
        authInfo = authInfo,
    )
}

fun persona(
    id: Long = IdGenerator.generate(),
    type: PersonaType = PersonaType.CAT,
    user: User,
) = Persona(
    id = id,
    type = type,
    level = Level(0),
    visible = false,
    appVisible = false,
    user = user,
)
