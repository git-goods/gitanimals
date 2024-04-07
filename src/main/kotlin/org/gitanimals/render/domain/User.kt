package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot

@AggregateRoot
@Entity(name = "user")
@Table(name = "user", indexes = [Index(columnList = "name")])
class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", unique = true, nullable = false)
    val name: String,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    private val personas: MutableList<Persona> = mutableListOf(),
) : AbstractTime() {

    init {
        personas.forEach { it.user = this }
    }

    fun createSvgAnimation(): String {
        val builder = StringBuilder().openSvg()

        personas.asSequence()
            .forEach { builder.append(it.toSvg()) }

        return builder.closeSvg().toString()
    }

    companion object {
        fun newUser(name: String): User {
            val defaultPersonas = mutableListOf(Persona(PersonaType.GOOSE, 0))
            return User(name = name, personas = defaultPersonas)
        }


        private fun StringBuilder.openSvg(): StringBuilder =
            this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

        private fun StringBuilder.closeSvg(): StringBuilder = this.append("</svg>")

    }
}
