package org.gitanimals.guild.domain

import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.hibernate.Hibernate
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GuildService(
    private val guildRepository: GuildRepository,
) {

    @Transactional
    fun createGuild(
        guildIcon: String,
        title: String,
        body: String,
        farmType: GuildFarmType,
        autoJoin: Boolean,
        createLeaderRequest: CreateLeaderRequest,
    ) {
        require(guildRepository.existsByTitle(title).not()) {
            "Cannot create guild cause duplicated guild already exists."
        }

        val leader = createLeaderRequest.toDomain()

        val newGuild = Guild.create(
            guildIcon = guildIcon,
            title = title,
            body = body,
            farmType = farmType,
            leader = leader,
            autoJoin = autoJoin,
        )

        guildRepository.save(newGuild)
    }

    @Transactional
    fun joinGuild(
        guildId: Long,
        memberUserId: Long,
        memberName: String,
        memberPersonaId: Long,
        memberContributions: Long,
    ) {
        val guild = getGuildById(guildId)

        guild.join(
            memberUserId = memberUserId,
            memberName = memberName,
            memberPersonaId = memberPersonaId,
            memberContributions = memberContributions,
        )
    }

    @Transactional
    fun acceptJoin(acceptorId: Long, guildId: Long, acceptUserId: Long) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, acceptorId)
            ?: throw IllegalArgumentException("Cannot accept join cause your not a leader.")

        guild.accept(acceptUserId)
    }

    @Transactional
    fun kickMember(kickerId: Long, guildId: Long, kickUserId: Long) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, kickerId)
            ?: throw IllegalArgumentException("Cannot kick member cause your not a leader.")

        guild.kickMember(kickUserId)
    }

    fun getGuildById(id: Long, vararg lazyLoading: (Guild) -> Unit): Guild {
        val guild = guildRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Cannot fint guild by id \"$id\"")

        lazyLoading.forEach { it.invoke(guild) }
        return guild
    }

    companion object {
        val loadMembers: (Guild) -> Unit = {
            Hibernate.initialize(it.getMembers())
        }

        val loadWaitMembers: (Guild) -> Unit = {
            Hibernate.initialize(it.getWaitMembers())
        }
    }
}
