package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Component

@Component
class LeaveGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun leave(guildId: Long) {
        val userId = internalAuth.getUserId()

        guildService.leave(guildId, userId)
    }
}
