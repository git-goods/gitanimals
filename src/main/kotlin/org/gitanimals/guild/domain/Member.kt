package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.PersonaType

@Entity
@Table(
    name = "member",
    indexes = [
        Index(name = "member_idx_name", columnList = "user_name"),
    ]
)
class Member(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "user_name", nullable = false)
    var name: String,

    @Column(name = "persona_id", nullable = false)
    var personaId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "persona_type", nullable = false, columnDefinition = "VARCHAR(255)")
    var personaType: PersonaType,

    @Column(name = "contributions", nullable = false)
    private var contributions: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    val guild: Guild,
) : AbstractTime() {

    fun getContributions() = contributions

    fun setContributions(contributions: Long) {
        this.contributions = contributions
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Member) return false

        return userId == other.userId
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    companion object {

        fun create(
            guild: Guild,
            userId: Long,
            name: String,
            personaId: Long,
            personaType: PersonaType,
            contributions: Long,
        ): Member {
            return Member(
                id = IdGenerator.generate(),
                userId = userId,
                name = name,
                personaId = personaId,
                personaType = personaType,
                guild = guild,
                contributions = contributions,
            )
        }
    }
}
