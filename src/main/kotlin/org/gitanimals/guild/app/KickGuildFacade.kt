package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class KickGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun kickMember(guildId: Long, kickUserId: Long) {
        val userId = internalAuth.getUserId()

        guildService.kickMember(
            kickerId = userId,
            guildId = guildId,
            kickUserId = kickUserId,
        )
    }
}
