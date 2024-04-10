package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot
import org.gitanimals.render.domain.value.Contribution
import org.hibernate.annotations.BatchSize
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

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

    @Column(name = "last_persona_give_point", nullable = false)
    private var lastPersonaGivePoint: Int,

    @Version
    @Column(name = "version", nullable = false)
    val version: Long,
) : AbstractTime() {

    init {
        personas.forEach { it.user = this }
    }

    fun isContributionUpdatedBeforeOneHour(): Boolean {
        val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
        val currentYearContribution =
            contributions.firstOrNull { it.year == currentYear } ?: return true

        return currentYearContribution.lastUpdatedContribution.isBefore(
            Instant.now().minus(1, ChronoUnit.HOURS)
        )
    }

    fun updateContribution(contribution: Int) {
        val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
        val currentYearContribution =
            contributions.first { it.year == currentYear }

        val newContribution = contribution - currentYearContribution.contribution

        currentYearContribution.contribution += newContribution
        lastPersonaGivePoint += newContribution
        currentYearContribution.lastUpdatedContribution = Instant.now()
        levelUpPersonas(newContribution)
        giveNewPersona()
    }

    private fun levelUpPersonas(newContribution: Int) {
        repeat(newContribution) {
            val persona = personas[Random.nextInt(0, personas.size)]
            persona.level.value++
        }
    }

    private fun giveNewPersona() {
        if (lastPersonaGivePoint >= FOR_NEW_PERSONA_COUNT) {
            lastPersonaGivePoint %= FOR_NEW_PERSONA_COUNT.toInt()
        }
        if (personas.size >= MAX_PERSONA_COUNT) {
            return
        }
        personas.add(Persona(PersonaType.random(), 0))
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
        private const val MAX_PERSONA_COUNT = 30L
        private const val MAX_INIT_PERSONA_COUNT = 10L
        private const val FOR_NEW_PERSONA_COUNT = 30L
        private const val FOR_INIT_PERSONA_COUNT = 100L

        private val nameConvention = Regex("[^a-zA-Z0-9-]")

        fun newUser(name: String, contributions: Map<Int, Int>): User {
            require(!nameConvention.containsMatchIn(name)) {
                throw IllegalArgumentException("Not supported word contained in \"${name}\"")
            }

            return User(
                name = name,
                personas = createPersonas(contributions),
                field = FieldType.WHITE_FIELD,
                contributions = contributions.map {
                    val year = it.key
                    val contribution = it.value
                    Contribution(year, contribution, Instant.now())
                }.toMutableList(),
                visit = 1,
                version = 0,
                lastPersonaGivePoint = (totalContributionCount(contributions) % FOR_NEW_PERSONA_COUNT).toInt()
            )
        }

        private fun createPersonas(contributions: Map<Int, Int>): MutableList<Persona> {
            val totalContributionCount = totalContributionCount(contributions)
            val personas = mutableListOf<Persona>()
            repeat(
                min(
                    MAX_INIT_PERSONA_COUNT,
                    max((totalContributionCount / FOR_INIT_PERSONA_COUNT), 1)
                ).toInt()
            ) {
                personas.add(Persona(PersonaType.random(), 0))
            }
            return personas
        }

        private fun totalContributionCount(contributions: Map<Int, Int>): Long {
            var totalCount = 0L
            contributions.forEach { totalCount += it.value }
            return totalCount
        }
    }
}
