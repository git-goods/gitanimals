package org.gitanimals.render.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot
import org.gitanimals.render.core.IdGenerator
import org.gitanimals.render.domain.response.PersonaResponse
import org.gitanimals.render.domain.value.Contribution
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
    val id: Long,

    @Column(name = "name", unique = true, nullable = false)
    val name: String,

    @OneToMany(
        mappedBy = "user",
        fetch = FetchType.EAGER,
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
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

    fun addPersona(personaType: PersonaType): PersonaResponse {
        val persona = Persona(personaType, 0L, personas.size < 30, this)

        this.personas.add(persona)

        return PersonaResponse.from(persona)
    }

    fun deletePersona(personaId: Long): PersonaResponse {
        val persona = this.personas.find { it.id == personaId }
            ?: throw IllegalArgumentException("Cannot find persona by id \"$personaId\"")

        this.personas.remove(persona)

        return PersonaResponse.from(persona)
    }

    @JsonIgnore
    fun isContributionUpdatedBeforeOneHour(): Boolean {
        val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
        val currentYearContribution =
            contributions.firstOrNull { it.year == currentYear } ?: return true

        return currentYearContribution.lastUpdatedContribution.isBefore(
            Instant.now().minus(1, ChronoUnit.HOURS)
        )
    }

    fun changePersonaVisible(personaId: Long, visible: Boolean): Persona {
        val persona = personas.find { it.id == personaId }
            ?: throw IllegalArgumentException("Cannot find persona by id \"$personaId\"")

        val visiblePersonas = personas.filter { it.visible }

        require(visiblePersonas.size < MAX_PERSONA_COUNT) {
            "Persona count must be under \"$MAX_PERSONA_COUNT\" but, current persona count is \"${visiblePersonas.size}\""
        }

        persona.visible = visible
        return persona
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

        val newPersona = getRandomPersona()
        personas.add(newPersona)
    }

    fun giveBonusPersona(persona: String) {
        val personaType = PersonaType.valueOf(persona.uppercase())

        require(bonusPersonas.contains(personaType)) {
            "Cannot select as a bonus persona."
        }

        personas.add(getPersona(personaType))
    }

    private fun getRandomPersona() = getPersona(PersonaType.random())

    private fun getPersona(personaType: PersonaType): Persona {
        return Persona(
            type = personaType,
            level = 0,
            visible = personas.size < MAX_PERSONA_COUNT,
            user = this,
        )
    }

    fun increaseVisitCount() {
        visit += 1
    }

    fun createLineAnimation(personaId: Long, mode: Mode): String {
        val builder = StringBuilder().openLine()

        val persona = personas.find { it.id!! >= personaId }
            ?: throw IllegalArgumentException("Cannot find persona by id \"$personaId\"")
        builder.append(persona.toSvgForce(mode))

        return builder.closeSvg()
    }

    private fun StringBuilder.openLine(): StringBuilder {
        return this.append("<svg fill=\"none\" overflow=\"visible\" xmlns=\"http://www.w3.org/2000/svg\">")
    }

    fun createFarmAnimation(): String {
        val builder = StringBuilder().openFarm()
            .append(field.fillBackground())

        personas.asSequence()
            .forEach { builder.append(it.toSvg(Mode.FARM)) }

        return builder.append(field.loadComponent(name, contributions.totalCount()))
            .append(field.drawBorder())
            .closeSvg()
    }

    fun contributionCount(): Long = contributions.totalCount()

    private fun List<Contribution>.totalCount(): Long {
        var totalCount = 0L
        this.forEach { totalCount += it.contribution }
        return totalCount
    }

    private fun StringBuilder.openFarm(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeSvg(): String = this
        .append("</svg>")
        .toString()

    companion object {
        private const val MAX_PERSONA_COUNT = 30L
        private const val MAX_INIT_PERSONA_COUNT = 10L
        private const val FOR_NEW_PERSONA_COUNT = 30L
        private const val FOR_INIT_PERSONA_COUNT = 100L

        private val nameConvention = Regex("[^a-zA-Z0-9-]")
        private val bonusPersonas = listOf(
            PersonaType.PENGUIN, PersonaType.GOOSE, PersonaType.LITTLE_CHICK,
            PersonaType.SLIME_RED, PersonaType.SLIME_BLUE, PersonaType.SLIME_GREEN,
            PersonaType.PIG,
        )

        fun newUser(name: String, contributions: Map<Int, Int>): User {
            require(!nameConvention.containsMatchIn(name)) {
                throw IllegalArgumentException("Not supported word contained in \"${name}\"")
            }

            return User(
                id = IdGenerator.generate(),
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
