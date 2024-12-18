package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.guild.core.AggregateRoot
import org.gitanimals.guild.core.IdGenerator

@Entity
@AggregateRoot
@Table(
    name = "guild",
    indexes = [
        Index(name = "guild_idx_title", unique = true, columnList = "title")
    ]
)
class Guild(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "guild_icon", nullable = false)
    val guildIcon: String,

    @Column(name = "title", unique = true, nullable = false, length = 50)
    val title: String,

    @Column(name = "body", columnDefinition = "TEXT", length = 500)
    val body: String,

    @Embedded
    val leader: Leader,

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

    private var autoJoin: Boolean,

    @Version
    private var version: Long? = null,
) : AbstractTime() {

    companion object {

        fun create(
            guildIcon: String,
            title: String,
            body: String,
            leader: Leader,
            members: MutableSet<Member> = mutableSetOf(),
            farmType: GuildFarmType,
            autoJoin: Boolean,
        ): Guild {

            return Guild(
                id = IdGenerator.generate(),
                guildIcon = guildIcon,
                title = title,
                body = body,
                leader = leader,
                members = members,
                farmType = farmType,
                autoJoin = autoJoin,
            )
        }
    }
}
