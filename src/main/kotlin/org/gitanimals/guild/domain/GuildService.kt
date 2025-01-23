package org.gitanimals.guild.domain

import org.gitanimals.core.FieldType
import org.gitanimals.core.PersonaType
import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.hibernate.Hibernate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.orm.ObjectOptimisticLockingFailureException
import org.springframework.retry.annotation.Retryable
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
        farmType: FieldType,
        autoJoin: Boolean,
        createLeaderRequest: CreateLeaderRequest,
    ): Guild {
        val forbiddenWords = listOf("fuck")

        require(forbiddenWords.none { title.contains(it, ignoreCase = true) }) {
            "The title contains forbidden words and cannot be used."
        }

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

        return guildRepository.save(newGuild)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun joinGuild(
        guildId: Long,
        memberUserId: Long,
        memberName: String,
        memberPersonaId: Long,
        memberPersonaType: PersonaType,
        memberContributions: Long,
    ) {
        val guild = getGuildById(guildId)

        guild.join(
            memberUserId = memberUserId,
            memberName = memberName,
            memberPersonaId = memberPersonaId,
            memberContributions = memberContributions,
            memberPersonaType = memberPersonaType,
        )
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun acceptJoin(acceptorId: Long, guildId: Long, acceptUserId: Long) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, acceptorId)
            ?: throw IllegalArgumentException("Cannot accept join cause your not a leader.")

        guild.accept(acceptUserId)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun denyJoin(denierId: Long, guildId: Long, denyUserId: Long) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, denierId)
            ?: throw IllegalArgumentException("Cannot deny join cause your not a leader.")

        guild.deny(denyUserId)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun kickMember(kickerId: Long, guildId: Long, kickUserId: Long) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, kickerId)
            ?: throw IllegalArgumentException("Cannot kick member cause your not a leader.")

        guild.kickMember(kickUserId)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun changeGuild(changeRequesterId: Long, guildId: Long, request: ChangeGuildRequest) {
        val guild = guildRepository.findGuildByIdAndLeaderId(guildId, changeRequesterId)
            ?: throw IllegalArgumentException("Cannot change guild cause your not a leader.")

        guild.change(request)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun changeMainPersona(guildId: Long, userId: Long, personaId: Long, personaType: PersonaType) {
        val guild = getGuildById(guildId)

        guild.changeMainPersona(userId, personaId, personaType)
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun leave(guildId: Long, userId: Long) {
        val guild = getGuildById(guildId)

        guild.leave(userId)
    }

    fun getGuildById(id: Long, vararg lazyLoading: (Guild) -> Unit): Guild {
        val guild = guildRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Cannot fint guild by id \"$id\"")

        lazyLoading.forEach { it.invoke(guild) }
        return guild
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun updateContribution(username: String, contributions: Long) {
        val guilds = guildRepository.findAllGuildByUsernameWithMembers(username)

        guilds.forEach { it.updateContributions(username, contributions) }
    }

    fun findAllGuildByUserId(userId: Long): List<Guild> {
        return guildRepository.findAllGuildByUserIdWithMembers(userId).onEach {
            loadWaitMembers.invoke(it)
        }
    }

    fun search(text: String, pageNumber: Int, filter: SearchFilter): Page<Guild> {
        return if (text.isBlank()) {
            guildRepository.search(Pageable.ofSize(PAGE_SIZE).withPage(pageNumber))
        } else {
            guildRepository.search(text, Pageable.ofSize(PAGE_SIZE).withPage(pageNumber))
        }.onEach {
            loadMembers.invoke(it)
            loadWaitMembers.invoke(it)
        }
    }

    fun findAllWithLimit(limit: Int): List<Guild> {
        return guildRepository.findAllWithLimit(Pageable.ofSize(limit)).onEach {
            loadMembers.invoke(it)
            loadWaitMembers.invoke(it)
        }
    }

    @Transactional
    @Retryable(ObjectOptimisticLockingFailureException::class)
    fun deletePersonaSync(
        userId: Long,
        deletedPersonaId: Long,
        changePersonaId: Long,
        changePersonaType: PersonaType,
    ) {
        val guilds = guildRepository.findAllGuildByUserIdWithMembers(userId)

        guilds.forEach {
            it.changePersonaIfDeleted(
                userId = userId,
                deletedPersonaId = deletedPersonaId,
                changePersonaId = changePersonaId,
                changePersonaType = changePersonaType,
            )
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
