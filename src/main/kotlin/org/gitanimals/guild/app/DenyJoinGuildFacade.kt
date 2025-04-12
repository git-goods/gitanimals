package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class DenyJoinGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun denyJoin(guildId: Long, denyUserId: Long) {
        val userId = internalAuth.getUserId()

        guildService.denyJoin(denierId = userId, guildId = guildId, denyUserId = denyUserId)
    }
}
