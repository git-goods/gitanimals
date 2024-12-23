package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Service

@Service
class KickGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun kickMember(token: String, guildId: Long, kickUserId: Long) {
        val user = identityApi.getUserByToken(token)

        guildService.kickMember(
            kickerId = user.id.toLong(),
            guildId = guildId,
            kickUserId = kickUserId,
        )
    }
}
