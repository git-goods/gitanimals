package org.gitanimals.guild.domain

import jakarta.persistence.*
import org.gitanimals.core.AggregateRoot
import org.gitanimals.core.FieldType
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.PersonaType
import org.gitanimals.guild.domain.extension.GuildFieldTypeExtension.isGuildField
import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.hibernate.annotations.BatchSize

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
    private var guildIcon: String,

    @Column(name = "title", unique = true, nullable = false, length = 50)
    private var title: String,

    @Column(name = "body", columnDefinition = "TEXT", length = 500)
    private var body: String,

    @Embedded
    private val leader: Leader,

    @Enumerated(EnumType.STRING)
    @Column(name = "farm_type", nullable = false, columnDefinition = "TEXT")
    private var farmType: FieldType,

    @Column(name = "auto_join", nullable = false)
    private var autoJoin: Boolean,

    @OneToMany(
        mappedBy = "guild",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
    )
    @BatchSize(size = 10)
    private val members: MutableSet<Member> = mutableSetOf(),

    @OneToMany(
        mappedBy = "guild",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
    )
    @BatchSize(size = 10)
    private val waitMembers: MutableSet<WaitMember> = mutableSetOf(),

    @Version
    private var version: Long? = null,
) : AbstractTime() {

    fun getMembers(): Set<Member> = members.toSet()

    fun getWaitMembers(): Set<WaitMember> = waitMembers.toSet()

    fun isAutoJoin(): Boolean = autoJoin

    fun join(
        memberUserId: Long,
        memberName: String,
        memberPersonaId: Long,
        memberContributions: Long,
        memberPersonaType: PersonaType,
    ) {
        require(leader.userId != memberUserId) {
            "Leader cannot join their own guild leaderId: \"${leader.userId}\", memberUserId: \"$memberUserId\""
        }

        if (autoJoin) {
            val member = Member.create(
                guild = this,
                userId = memberUserId,
                name = memberName,
                personaId = memberPersonaId,
                contributions = memberContributions,
                personaType = memberPersonaType,
            )
            members.add(member)
            return
        }

        val waitMember = WaitMember.create(
            guild = this,
            userId = memberUserId,
            name = memberName,
            personaId = memberPersonaId,
            contributions = memberContributions,
            personaType = memberPersonaType,
        )
        waitMembers.add(waitMember)
    }

    fun getLeaderUserId(): Long = leader.userId

    fun accept(acceptUserId: Long) {
        val acceptUser = waitMembers.firstOrNull { it.userId == acceptUserId }
            ?: throw IllegalArgumentException("Cannot find waitMember by userId: \"$acceptUserId\"")
        waitMembers.remove(acceptUser)

        members.add(acceptUser.toMember())
    }

    fun deny(denyUserId: Long) {
        waitMembers.removeIf { it.userId == denyUserId }
    }

    fun kickMember(kickUserId: Long) {
        members.removeIf { it.userId == kickUserId }
    }

    fun change(request: ChangeGuildRequest) {
        GuildIcons.requireExistImagePath(request.guildIcon)

        this.title = request.title
        this.body = request.body
        this.farmType = request.farmType
        this.guildIcon = request.guildIcon
        this.autoJoin = request.autoJoin
    }

    fun getTitle(): String = title

    fun getBody(): String = body

    fun getGuildIcon(): String = guildIcon

    fun getLeaderName(): String = leader.name

    fun getContributions(): Long = leader.contributions

    fun getGuildFarmType(): FieldType = farmType

    fun getTotalContributions(): Long {
        return leader.contributions + members.sumOf { it.getContributions() }
    }

    fun updateContributions(username: String, contributions: Long) {
        if (leader.name == username) {
            leader.contributions = contributions
            return
        }
        members.firstOrNull { it.name == username }?.setContributions(contributions)
    }

    fun changePersonaIfDeleted(
        userId: Long,
        deletedPersonaId: Long,
        changePersonaId: Long,
        changePersonaType: PersonaType,
    ) {
        if (leader.userId == userId) {
            if (leader.personaId == deletedPersonaId) {
                leader.personaId = changePersonaId
                leader.personaType = changePersonaType
            }
            return
        }

        members.firstOrNull {
            it.userId == userId && it.personaId == deletedPersonaId
        }?.let {
            it.personaId = changePersonaId
            it.personaType = changePersonaType
        }

        waitMembers.firstOrNull {
            it.userId == userId && it.personaId == deletedPersonaId
        }?.let {
            it.personaId = changePersonaId
            it.personaType = changePersonaType
        }
    }

    fun getLeaderPersonaId(): Long {
        return leader.personaId
    }

    fun getLeaderPersonaType(): PersonaType {
        return leader.personaType
    }

    fun changeMainPersona(userId: Long, personaId: Long, personaType: PersonaType) {
        if (leader.userId == userId) {
            leader.personaId = personaId
            leader.personaType = personaType
            return
        }

        members.first {
            it.userId == userId
        }.run {
            this.personaId = personaId
            this.personaType = personaType
        }
    }

    fun leave(userId: Long) {
        require(userId != leader.userId) {
            "Leader cannot leave guild guildId: \"$id\", userId: \"$userId\""
        }

        members.removeIf { it.userId == userId }
    }

    companion object {

        fun create(
            guildIcon: String,
            title: String,
            body: String,
            leader: Leader,
            members: MutableSet<Member> = mutableSetOf(),
            farmType: FieldType,
            autoJoin: Boolean,
        ): Guild {
            require(farmType.isGuildField()) {
                "Cannot create guild cause \"$farmType\" is not guild field."
            }

            GuildIcons.requireExistImagePath(guildIcon)

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
