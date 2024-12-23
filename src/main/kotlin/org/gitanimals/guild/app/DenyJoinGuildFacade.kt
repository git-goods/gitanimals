package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class DenyJoinGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun denyJoin(token: String, guildId: Long, denyUserId: Long) {
        val user = identityApi.getUserByToken(token)

        guildService.denyJoin(denierId = user.id.toLong(), guildId = guildId, denyUserId = denyUserId)
    }
}
