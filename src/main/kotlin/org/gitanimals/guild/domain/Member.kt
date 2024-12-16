package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.guild.core.IdGenerator

@Entity
@Table(name = "member")
class Member(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "persona_id", nullable = false)
    val personaId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    val guild: Guild,
): AbstractTime() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Member) return false

        return userId == other.userId
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    companion object {

        fun create(guild: Guild, userId: Long, personaId: Long): Member {
            return Member(
                id = IdGenerator.generate(),
                userId = userId,
                personaId = personaId,
                guild = guild,
            )
        }
    }
}
