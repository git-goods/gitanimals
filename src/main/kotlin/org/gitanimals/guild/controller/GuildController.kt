package org.gitanimals.guild.controller

import org.gitanimals.guild.app.*
import org.gitanimals.guild.app.request.CreateGuildRequest
import org.gitanimals.guild.controller.request.JoinGuildRequest
import org.gitanimals.guild.domain.request.ChangeGuildRequest
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
class GuildController(
    private val createGuildFacade: CreateGuildFacade,
    private val joinGuildFacade: JoinGuildFacade,
    private val acceptJoinGuildFacade: AcceptJoinGuildFacade,
    private val kickGuildFacade: KickGuildFacade,
    private val changeGuildFacade: ChangeGuildFacade,
) {

    @PostMapping("/guilds")
    fun createGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody createGuildRequest: CreateGuildRequest,
    ) = createGuildFacade.createGuild(token, createGuildRequest)


    @PostMapping("/guilds/{guildId}")
    fun joinGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("guildId") guildId: Long,
        @RequestBody joinGuildRequest: JoinGuildRequest,
    ) = joinGuildFacade.joinGuild(token, guildId, joinGuildRequest.personaId.toLong())

    @PostMapping("/guilds/{guildId}/accepts")
    fun acceptJoinGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("guildId") guildId: Long,
        @RequestParam("user-id") acceptUserId: Long,
    ) = acceptJoinGuildFacade.acceptJoin(token, guildId, acceptUserId)

    @DeleteMapping("/guilds/{guildId}")
    fun kickFromGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("guildId") guildId: Long,
        @RequestParam("user-id") kickUserId: Long,
    ) = kickGuildFacade.kickMember(token, guildId, kickUserId)

    @PatchMapping("/guilds/{guildId}")
    fun changeGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable("guildId") guildId: Long,
        @RequestBody changeGuildRequest: ChangeGuildRequest,
    ) = changeGuildFacade.changeGuild(token, guildId, changeGuildRequest)
}
