package org.gitanimals.guild.app

import org.gitanimals.core.Mode
import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.GuildService.Companion.loadMembers
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class DrawGuildFacade(
    private val renderApi: RenderApi,
    private val guildService: GuildService,
    @Value("\${internal.secret}") private val internalSecret: String,
) {

    fun drawGuild(id: Long): String {
        val guild = guildService.getGuildById(id, loadMembers)
        val renderUsers = getRenderUsers(guild)

        val svgBuilder = StringBuilder().openGuild()
            .append(guild.getGuildFarmType().fillBackground())

        val personaSvgs = renderUsers.map { user ->
            val persona = user.personas.firstOrNull()
                ?: throw IllegalArgumentException("Cannot draw guild cause user does not have any persona. user: \"$user\"")

            persona.type.load(
                name = user.name,
                contributionCount = user.totalContributions.toLong(),
                animationId = persona.id.toLong(),
                level = persona.level.toLong(),
                mode = Mode.NAME_WITH_LEVEL,
            )
        }

        personaSvgs.forEach { svgBuilder.append(it) }

        return svgBuilder.append(
            guild.getGuildFarmType().loadComponent(guild.getTitle(), guild.getTotalContributions())
        ).append(guild.getGuildFarmType().drawBorder())
            .closeGuild()
    }

    private fun getRenderUsers(guild: Guild): List<RenderApi.UserResponse> {
        val usernameAndPersonaIdRequests = guild.getMembers().map {
            RenderApi.UsernameAndPersonaIdRequest(
                personaId = it.personaId,
                username = it.name,
            )
        } + RenderApi.UsernameAndPersonaIdRequest(
            personaId = guild.getLeaderPersonaId(),
            username = guild.getLeaderName(),
        )

        return renderApi.getAllPersonasByUserIdsAndPersonaIds(
            internalSecret = internalSecret,
            usernameAndPersonaIdRequests = usernameAndPersonaIdRequests,
        )
    }


    private fun StringBuilder.openGuild(): StringBuilder =
        this.append("<svg width=\"600\" height=\"300\" viewBox=\"0 0 600 300\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">")

    private fun StringBuilder.closeGuild(): String = this
        .append("</svg>")
        .toString()

}