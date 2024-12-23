package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class AcceptJoinGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun acceptJoin(token: String, guildId: Long, acceptUserId: Long) {
        val user = identityApi.getUserByToken(token)

        guildService.acceptJoin(
            acceptorId = user.id.toLong(),
            guildId = guildId,
            acceptUserId = acceptUserId,
        )
    }
}
