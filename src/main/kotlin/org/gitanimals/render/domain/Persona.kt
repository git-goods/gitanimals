package org.gitanimals.render.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.Mode
import org.gitanimals.core.PersonaEvolution
import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.value.Level

@Table(name = "persona")
@Entity(name = "persona")
class Persona(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    @Enumerated(EnumType.STRING)
    private var type: PersonaType,

    @Embedded
    val level: Level,

    @Column(name = "visible", nullable = false)
    var visible: Boolean,

    @Column(name = "app_visible", nullable = false, columnDefinition = "bit(1) DEFAULT 0")
    var appVisible: Boolean = false,

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var user: User? = null,

    @Version
    @Column(name = "version", nullable = false)
    var version: Long? = null,
) : AbstractTime() {

    constructor(
        type: PersonaType,
        level: Long,
        visible: Boolean
    ) : this(id = IdGenerator.generate(), type = type, level = Level(level), visible = visible)

    constructor(
        type: PersonaType,
        level: Long,
        visible: Boolean,
        user: User,
    ) : this(
        id = IdGenerator.generate(),
        type = type,
        level = Level(level),
        visible = visible,
        user = user
    )

    fun getType() = this.type

    fun toSvgForce(mode: Mode): String = type.load(
        name = user!!.getName(),
        contributionCount = user!!.contributionCount(),
        animationId = this.id,
        level = this.level(),
        mode = mode,
    )

    fun toSvg(mode: Mode): String {
        if (!visible) {
            return ""
        }
        
        return type.load(
            name = user!!.getName(),
            contributionCount = user!!.contributionCount(),
            animationId = this.id,
            level = this.level(),
            mode = mode,
        )
    }

    fun level(): Long = level.value

    fun isEvolutionable(): Boolean {
        return level() >= EVOLUTION_REQUIRED_LEVEL && getType().personaEvolution != PersonaEvolution.nothing
    }

    fun evolution() {
        require (type.personaEvolution != PersonaEvolution.nothing) {
            "Evolution fail cause, not support evolution type :${type.name}"
        }
        require(level() >= EVOLUTION_REQUIRED_LEVEL) {
            "Cannot evolution persona cause, ${level()} is not enough level for evolution."
        }

        val evolutionedPersonaType = this.type.randomEvolution()
        this.type = evolutionedPersonaType
        this.level.value -= 100
    }

    companion object {
        private const val EVOLUTION_REQUIRED_LEVEL = 100L
    }
}
