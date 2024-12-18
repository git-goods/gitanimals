package org.gitanimals.guild.controller

import org.gitanimals.guild.app.CreateGuildFacade
import org.gitanimals.guild.app.request.CreateGuildRequest
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class GuildController(
    private val createGuildFacade: CreateGuildFacade,
) {

    @PostMapping("/guilds")
    fun createGuild(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody createGuildRequest: CreateGuildRequest,
    ) = createGuildFacade.createGuild(token, createGuildRequest)


}
