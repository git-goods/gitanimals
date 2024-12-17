package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.guild.core.AggregateRoot
import org.gitanimals.guild.core.IdGenerator

@Entity
@AggregateRoot
@Table(name = "guild")
class Guild(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "guild_icon", nullable = false)
    val guildIcon: String,

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    val title: String,

    @Column(name = "body", columnDefinition = "TEXT", length = 500)
    val body: String,

    @Column(name = "leader_id", nullable = false)
    val leaderId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "farm_type", nullable = false, columnDefinition = "TEXT")
    val farmType: GuildFarmType,

    @OneToMany(
        mappedBy = "guild",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
    )
    private val members: MutableSet<Member>,
) : AbstractTime() {

    companion object {

        fun create(
            guildIcon: String,
            title: String,
            body: String,
            leaderId: Long,
            members: MutableSet<Member> = mutableSetOf(),
            farmType: GuildFarmType,
        ): Guild {

            return Guild(
                id = IdGenerator.generate(),
                guildIcon = guildIcon,
                title = title,
                body = body,
                leaderId = leaderId,
                members = members,
                farmType = farmType,
            )
        }
    }
}
