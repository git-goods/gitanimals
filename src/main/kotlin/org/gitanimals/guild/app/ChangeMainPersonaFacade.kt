package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.springframework.stereotype.Component

@Component
class ChangeMainPersonaFacade(
    private val renderApi: RenderApi,
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
) {

    fun changeMainPersona(token: String, guildId: Long, personaId: Long) {
        val user = identityApi.getUserByToken(token)
        val personas = renderApi.getUserByName(user.username).personas

        val changedPersona = personas.firstOrNull { it.id.toLong() == personaId }
            ?: throw IllegalArgumentException("Cannot change persona to \"$personaId\" from user \"${user.username}\"")

        guildService.changeMainPersona(
            guildId = guildId,
            userId = user.id.toLong(),
            personaId = changedPersona.id.toLong(),
            personaType = changedPersona.type,
        )
    }
}
