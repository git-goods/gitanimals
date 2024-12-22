package org.gitanimals.guild.app

import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class GetJoinedGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun getJoinedGuilds(token: String): List<Guild> {
        val user = identityApi.getUserByToken(token)

        return guildService.findAllGuildByUserId(user.id)
    }
}
