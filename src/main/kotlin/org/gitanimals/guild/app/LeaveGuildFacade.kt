package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Component

@Component
class LeaveGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun leave(token: String, guildId: Long) {
        val user = identityApi.getUserByToken(token)

        guildService.leave(guildId, user.id.toLong())
    }
}
