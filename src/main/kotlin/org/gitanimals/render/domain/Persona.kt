package org.gitanimals.render.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.gitanimals.render.domain.value.Level

@Table(name = "persona")
@Entity(name = "persona")
class Persona(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: PersonaType,

    @Embedded
    val level: Level,
) : AbstractTime() {

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    lateinit var user: User

    constructor(
        type: PersonaType,
        level: Long,
    ) : this(type = type, level = Level(level, 0))


    fun toSvg(): String = type.load(this)
}
