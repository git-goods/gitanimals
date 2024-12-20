package org.gitanimals.guild.controller

import org.gitanimals.guild.app.AcceptJoinGuildFacade
import org.gitanimals.guild.app.CreateGuildFacade
import org.gitanimals.guild.app.JoinGuildFacade
import org.gitanimals.guild.app.request.CreateGuildRequest
import org.gitanimals.guild.controller.request.JoinGuildRequest
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
class GuildController(
    private val createGuildFacade: CreateGuildFacade,
    private val joinGuildFacade: JoinGuildFacade,
    private val acceptJoinGuildFacade: AcceptJoinGuildFacade,
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
}