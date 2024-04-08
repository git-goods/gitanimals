package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot
import org.gitanimals.render.domain.value.Contribution
import org.hibernate.annotations.BatchSize

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

    @BatchSize(size = 20)
    @ElementCollection(fetch = FetchType.LAZY)
    private val contributions: MutableList<Contribution> = mutableListOf(),

    @Column(name = "visit", nullable = false)
    private var visit: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "field_type", nullable = false)
    val field: FieldType,

    @Version
    @Column(name = "version", nullable = false)
    val version: Long,
) : AbstractTime() {

    init {
        require(!nameConvention.containsMatchIn(name)) {
            throw IllegalArgumentException("Not supported word contained in \"${name}\"")
        }

        personas.forEach { it.user = this }
    }

    fun increaseVisitCount() {
        visit += 1
    }

    fun createSvgAnimation(): String {
        val builder = StringBuilder().openSvg()
            .append(field.fillBackground())

        personas.asSequence()
            .forEach { builder.append(it.toSvg()) }

        return builder.append(field.loadComponent(name, contributions.totalCount(), visit))
            .append(field.drawBorder())
            .closeSvg()
    }

    private fun List<Contribution>.totalCount(): Long {
        var totalCount = 0L
        this.forEach { totalCount += it.contribution }
        return totalCount
    }

    private fun StringBuilder.openSvg(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeSvg(): String = this.append("</svg>").toString()

    companion object {

        private val nameConvention = Regex("[^a-zA-Z0-9-]")

        fun newUser(name: String, contributions: Map<Int, Int>): User {
            val defaultPersonas = mutableListOf(Persona(PersonaType.GOOSE, 0))
            return User(
                name = name,
                personas = defaultPersonas,
                field = FieldType.WHITE_FIELD,
                contributions = contributions.map {
                    val year = it.key
                    val contribution = it.value
                    Contribution(year, contribution)
                }.toMutableList(),
                visit = 1,
                version = 0,
            )
        }
    }
}
