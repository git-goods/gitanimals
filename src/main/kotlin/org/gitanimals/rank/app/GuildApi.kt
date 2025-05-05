package org.gitanimals.rank.app

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import java.time.Instant

interface GuildApi {

    @GetExchange("/internals/guilds/by-title/{title}")
    fun getGuildByTitle(@PathVariable("title") title: String): GuildResponse

    @GetExchange("/guilds/{guildId}")
    fun getGuildById(@PathVariable("guildId") guildId: Long): GuildResponse

    data class GuildResponse(
        val id: String,
        val title: String,
        val body: String,
        val guildIcon: String,
        val leader: org.gitanimals.guild.app.response.GuildResponse.Leader,
        val farmType: String,
        val totalContributions: String,
        val members: List<org.gitanimals.guild.app.response.GuildResponse.Member>,
        val waitMembers: List<org.gitanimals.guild.app.response.GuildResponse.WaitMember>,
        val autoJoin: Boolean,
        @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "UTC"
        )
        val createdAt: Instant,
    )
}
