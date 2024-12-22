package org.gitanimals.guild.controller.response

import com.fasterxml.jackson.annotation.JsonFormat
import org.gitanimals.guild.domain.Guild
import java.time.Instant

data class GuildResponse(
    val id: String,
    val title: String,
    val body: String,
    val guildIcon: String,
    val leader: Leader,
    val farmType: String,
    val totalContributions: String,
    val members: List<Member>,
    val waitMembers: List<WaitMember>,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "UTC"
    )
    val createdAt: Instant,
) {
    data class Leader(
        val userId: String,
        val name: String,
        val contributions: String,
        val personaId: String,
    )

    data class Member(
        val id: String,
        val userId: String,
        val name: String,
        val contributions: String,
        val personaId: String,
    )

    data class WaitMember(
        val id: String,
        val userId: String,
        val name: String,
        val contributions: String,
        val personaId: String,
    )

    companion object {

        fun from(guild: Guild): GuildResponse {
            return GuildResponse(
                id = guild.id.toString(),
                title = guild.getTitle(),
                body = guild.getBody(),
                guildIcon = guild.getGuildIcon(),
                leader = Leader(
                    userId = guild.getLeaderId().toString(),
                    name = guild.getLeaderName(),
                    contributions = guild.getContributions().toString(),
                    personaId = guild.getLeaderPersonaId().toString(),
                ),
                farmType = guild.getGuildFarmType().toString(),
                totalContributions = guild.getTotalContributions().toString(),
                members = guild.getMembers().map {
                    Member(
                        id = it.id.toString(),
                        userId = it.userId.toString(),
                        name = it.name,
                        contributions = it.getContributions().toString(),
                        personaId = it.personaId.toString(),
                    )
                },
                waitMembers = guild.getWaitMembers().map {
                    WaitMember(
                        id = it.id.toString(),
                        userId = it.userId.toString(),
                        name = it.name,
                        contributions = it.getContributions().toString(),
                        personaId = it.personaId.toString(),
                    )
                },
                createdAt = guild.createdAt,
            )
        }
    }
}
