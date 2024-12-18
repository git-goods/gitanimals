package org.gitanimals.guild.domain

import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GuildService(
    private val guildRepository: GuildRepository,
) {

    fun getGuildById(id: Long): Guild = guildRepository.findByIdOrNull(id)
        ?: throw IllegalArgumentException("Cannot fint guild by id \"$id\"")

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
}
