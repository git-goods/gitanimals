package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.guild.core.IdGenerator

@Entity
@Table(
    name = "wait_member",
    indexes = [
        Index(
            name = "wait_member_idx_id_user_id",
            columnList = "id, user_id",
            unique = true,
        )
    ]
)
class WaitMember(
    @Id
    val id: Long,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "user_name", nullable = false)
    val name: String,

    @Column(name = "persona_id", nullable = false)
    val personaId: Long,

    @Column(name = "contributions", nullable = false)
    private var contributions: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    val guild: Guild,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WaitMember) return false

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
            contributions: Long,
        ): WaitMember {
            return WaitMember(
                id = IdGenerator.generate(),
                userId = userId,
                name = name,
                personaId = personaId,
                guild = guild,
                contributions = contributions,
            )
        }
    }
}
