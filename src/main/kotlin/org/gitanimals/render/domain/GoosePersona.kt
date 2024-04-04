package org.gitanimals.render.domain

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "")
class GoosePersona(
    id: Long,
) : Persona(id) {

    override fun act(): String {
        TODO("impl act")
    }
}
