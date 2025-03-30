package org.gitanimals.guild.app

import org.gitanimals.guild.app.event.InboxInputEvent
import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.GuildService.Companion.loadMembers
import org.rooftop.netx.api.SagaManager
import org.springframework.stereotype.Service

@Service
class JoinGuildFacade(
    private val renderApi: RenderApi,
    private val identityApi: IdentityApi,
    private val guildService: GuildService,
    private val sagaManager: SagaManager,
) {

    fun joinGuild(
        token: String,
        guildId: Long,
        memberPersonaId: Long,
    ) {
        val member = identityApi.getUserByToken(token)
        val renderInfo = renderApi.getUserByName(member.username)

        require(memberPersonaId in renderInfo.personas.map { it.id.toLong() }) {
            "Cannot join guild cause user does not have request member persona id. personaId: \"$memberPersonaId\""
        }

        guildService.joinGuild(
            guildId = guildId,
            memberUserId = member.id.toLong(),
            memberName = member.username,
            memberPersonaId = memberPersonaId,
            memberContributions = renderInfo.totalContributions.toLong(),
            memberPersonaType = renderInfo.personas.find { it.id.toLong() == memberPersonaId }!!.type,
        )

        val guild = guildService.getGuildById(guildId, loadMembers)
        if (guild.isAutoJoin()) {
            publishNewUserJoinEvents(guild, member)
            return
        }

        publicGuildJoinRequest(guild, member)
        publishSentJoinRequest(guild, member)
    }

    private fun publishNewUserJoinEvents(
        guild: Guild,
        member: IdentityApi.UserResponse,
    ) {
        guild.getMembers()
            .filter { it.userId != member.id.toLong() }
            .forEach {
                sagaManager.startSync(
                    InboxInputEvent.newUserJoined(
                        userId = it.userId,
                        newUserImage = member.profileImage,
                        newUserName = member.username,
                        guildId = guild.id,
                        guildTitle = guild.getTitle(),
                    )
                )
            }
    }

    private fun publicGuildJoinRequest(
        guild: Guild,
        member: IdentityApi.UserResponse
    ) {
        sagaManager.startSync(
            InboxInputEvent.guildJoinRequest(
                userId = guild.getLeaderUserId(),
                newUserImage = member.profileImage,
                newUserName = member.username,
                guildId = guild.id,
                guildTitle = guild.getTitle(),
            )
        )
    }

    private fun publishSentJoinRequest(
        guild: Guild,
        member: IdentityApi.UserResponse,
    ) {
        sagaManager.startSync(
            InboxInputEvent.sentJoinRequest(
                userId = member.id.toLong(),
                guildId = guild.id,
                guildTitle = guild.getTitle(),
                guildIcon = guild.getGuildIcon(),
            )
        )
    }
}
