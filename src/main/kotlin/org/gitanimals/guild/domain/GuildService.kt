package org.gitanimals.guild.domain

import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.hibernate.Hibernate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    @Transactional
    fun changeGuild(changeRequesterId: Long, guildId: Long, request: ChangeGuildRequest) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, changeRequesterId)
            ?: throw IllegalArgumentException("Cannot kick member cause your not a leader.")

        guild.change(request)
    }

    fun getGuildById(id: Long, vararg lazyLoading: (Guild) -> Unit): Guild {
        val guild = guildRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Cannot fint guild by id \"$id\"")

        lazyLoading.forEach { it.invoke(guild) }
        return guild
    }

    @Transactional
    fun updateContribution(username: String, contributions: Long) {
        val guilds = guildRepository.findAllGuildByUsernameWithMembers(username)

        guilds.forEach { it.updateContributions(username, contributions) }
    }

    fun findAllGuildByUserId(userId: String): List<Guild> {
        return guildRepository.findAllGuildByUserIdWithMembers(userId).apply {
            this.forEach { loadWaitMembers.invoke(it) }
        }
    }

    fun search(text: String, pageNumber: Int, filter: SearchFilter): Page<Guild> {
        return guildRepository.search(text, Pageable.ofSize(PAGE_SIZE).withPage(pageNumber)).apply {
            this.forEach {
                loadMembers.invoke(it)
                loadWaitMembers.invoke(it)
            }
        }
    }

    fun findAllWithLimit(limit: Int): List<Guild> {
        return guildRepository.findAllWithLimit(Pageable.ofSize(limit)).apply {
            this.forEach {
                loadMembers.invoke(it)
                loadWaitMembers.invoke(it)
            }
        }
    }

    companion object {
        const val PAGE_SIZE = 9

        val loadMembers: (Guild) -> Unit = {
            Hibernate.initialize(it.getMembers())
        }

        val loadWaitMembers: (Guild) -> Unit = {
            Hibernate.initialize(it.getWaitMembers())
        }
    }
}
