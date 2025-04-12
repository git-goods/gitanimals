package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class AcceptJoinGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun acceptJoin(guildId: Long, acceptUserId: Long) {
        val userId = internalAuth.getUserId()

        guildService.acceptJoin(
            acceptorId = userId,
            guildId = guildId,
            acceptUserId = acceptUserId,
        )
    }
}
