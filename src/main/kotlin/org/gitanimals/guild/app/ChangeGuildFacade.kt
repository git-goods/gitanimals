package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.springframework.stereotype.Service

@Service
class ChangeGuildFacade(
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun changeGuild(token: String, guildId: Long, changeGuildRequest: ChangeGuildRequest) {
        val user = identityApi.getUserByToken(token)

        guildService.changeGuild(
            changeRequesterId = user.id.toLong(),
            guildId = guildId,
            request = changeGuildRequest,
        )
    }
}
