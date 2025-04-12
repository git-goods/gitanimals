package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class GetJoinedGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun getJoinedGuilds(): List<Guild> {
        val userId = internalAuth.getUserId()

        return guildService.findAllGuildByUserId(userId)
    }
}
