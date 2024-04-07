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

    @Column(name = "commit", nullable = false)
    val commit: Long,

    @Column(name = "visit", nullable = false)
    val visit: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "field_type", nullable = false)
    val field: FieldType,
) : AbstractTime() {

    init {
        personas.forEach { it.user = this }
    }

    fun createSvgAnimation(): String {
        val builder = StringBuilder().openSvg()
            .append(field.fillBackground())

        personas.asSequence()
            .forEach { builder.append(it.toSvg()) }

        return builder.append(field.loadComponent(name, commit, visit))
            .append(field.drawBorder())
            .closeSvg()
    }

    private fun StringBuilder.openSvg(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeSvg(): String = this.append("</svg>").toString()

    companion object {
        fun newUser(name: String): User {
            val defaultPersonas = mutableListOf(Persona(PersonaType.GOOSE, 0))
            return User(
                name = name,
                personas = defaultPersonas,
                commit = 1234567890,
                field = FieldType.WHITE_FIELD,
                visit = 4749,
            )
        }
    }
}
