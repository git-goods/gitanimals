package org.gitanimals.guild.app

import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.GuildService.Companion.loadMembers
import org.gitanimals.render.app.DrawGuildFacade
import org.springframework.stereotype.Service

@Service
class DrawGuildProxy(
    private val guildService: GuildService,
    private val renderDrawGuildFacade: DrawGuildFacade,
) {

    fun drawGuild(id: Long): String {
        val guild = guildService.getGuildById(id, loadMembers)

        return renderDrawGuildFacade.drawGuild(
            title = guild.getTitle(),
            totalContributions = guild.getTotalContributions(),
            fieldType = guild.getGuildFarmType(),
            userIds = guild.getMembers().map { it.userId } + guild.getLeaderUserId(),
            personaIds = guild.getMembers().map { it.personaId } + guild.getLeaderPersonaId(),
        )
    }
}
