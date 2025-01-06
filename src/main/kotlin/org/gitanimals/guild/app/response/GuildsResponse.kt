package org.gitanimals.guild.app.response

import org.gitanimals.guild.domain.Guild

data class GuildsResponse(
    val guilds: List<GuildResponse>,
) {

    companion object {

        fun from(guilds: List<Guild>): GuildsResponse {
            return GuildsResponse(guilds.map { GuildResponse.from(it) })
        }
    }
}
