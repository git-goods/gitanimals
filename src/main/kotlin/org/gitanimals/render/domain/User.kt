package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot
import org.gitanimals.render.domain.value.Contribution
import org.gitanimals.render.domain.value.Level
import org.hibernate.annotations.BatchSize
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.max
import kotlin.math.min

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
    val personas: MutableList<Persona> = mutableListOf(),

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
            contributions.firstOrNull { it.year == currentYear }
                ?: run {
                    val currentYearContribution = Contribution(currentYear, 0, Instant.now())
                    contributions.add(currentYearContribution)
                    currentYearContribution
                }

        val newContribution = contribution - currentYearContribution.contribution

        currentYearContribution.contribution += newContribution
        lastPersonaGivePoint += newContribution
        currentYearContribution.lastUpdatedContribution = Instant.now()
        levelUpPersonas(newContribution)
    }

    private fun levelUpPersonas(newContribution: Int) {
        repeat(newContribution) {
            runCatching {
                val persona = personas.random()
                persona.level.value++
            }.onFailure {
                it.printStackTrace()
                throw it
            }
        }
    }

    fun giveNewPersona() {
        if (lastPersonaGivePoint < FOR_NEW_PERSONA_COUNT) {
            return
        }
        lastPersonaGivePoint %= FOR_NEW_PERSONA_COUNT.toInt()

        val newPersona = when (personas.size >= MAX_PERSONA_COUNT) {
            true -> Persona(
                type = PersonaType.random(),
                level = Level(0),
                visible = false,
                user = this
            )

            false -> Persona(
                type = PersonaType.random(),
                level = Level(0),
                visible = true,
                user = this
            )
        }
        personas.add(newPersona)
    }

    fun increaseVisitCount() {
        visit += 1
    }

    fun createLineAnimation(personaId: Long): String {
        val builder = StringBuilder().openLine()

        val persona = personas.find { it.id!! >= personaId }
            ?: throw IllegalArgumentException("Cannot find persona by id \"$personaId\"")
        builder.append(persona.toSvg())

        return builder.closeSvg()
    }

    private fun StringBuilder.openLine(): StringBuilder {
        return this.append("<svg fill=\"none\" overflow=\"visible\" xmlns=\"http://www.w3.org/2000/svg\">")
    }

    fun createFarmAnimation(): String {
        val builder = StringBuilder().openFarm()
            .append(field.fillBackground())

        personas.asSequence()
            .forEach { builder.append(it.toSvg()) }

        return builder.append(field.loadComponent(name, contributions.totalCount()))
            .append(field.drawBorder())
            .closeSvg()
    }

    private fun List<Contribution>.totalCount(): Long {
        var totalCount = 0L
        this.forEach { totalCount += it.contribution }
        return totalCount
    }

    private fun StringBuilder.openFarm(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeSvg(): String = this.blackBlurOnLevel()
        .append("</svg>")
        .toString()

    private fun StringBuilder.blackBlurOnLevel(): StringBuilder =
        this.append(
            """
                    <style>
                        #level {
                            filter: url(#level_shadow)
                        }
                    </style>
                    
                    <defs>
                        <filter id="level_shadow" x="-200" y="-200" width="400" height="400" filterUnits="userSpaceOnUse" color-interpolation-filters="sRGB">
                            <feFlood flood-opacity="0" result="BackgroundImageFix"/>
                            <feColorMatrix in="SourceAlpha" type="matrix" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha"/>
                            <feOffset/>
                            <feGaussianBlur stdDeviation="0.5"/>
                            <feComposite in2="hardAlpha" operator="out"/>
                            <feColorMatrix type="matrix" values="0 0 0 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 1 0"/>
                            <feBlend mode="normal" in2="BackgroundImageFix" result="effect1_dropShadow_138_125"/>
                            <feBlend mode="normal" in="SourceGraphic" in2="effect1_dropShadow_138_125" result="shape"/>
                        </filter>
                    </defs>
            """.trimIndent()
        )

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
                personas.add(Persona(PersonaType.random(), 0, true))
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
