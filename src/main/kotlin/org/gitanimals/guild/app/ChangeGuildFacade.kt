package org.gitanimals.guild.app

import org.gitanimals.core.auth.InternalAuth
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.springframework.stereotype.Service

@Service
class ChangeGuildFacade(
    private val internalAuth: InternalAuth,
    private val guildService: GuildService,
) {

    fun changeGuild(guildId: Long, changeGuildRequest: ChangeGuildRequest) {
        changeGuildRequest.requireValidTitle()
        
        val userId = internalAuth.getUserId()

        guildService.changeGuild(
            changeRequesterId = userId,
            guildId = guildId,
            request = changeGuildRequest,
        )
    }
}
