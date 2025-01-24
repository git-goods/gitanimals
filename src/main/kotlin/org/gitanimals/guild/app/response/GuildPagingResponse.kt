package org.gitanimals.guild.app.response

import org.gitanimals.guild.domain.Guild
import org.springframework.data.domain.Page

data class GuildPagingResponse(
    val guilds: List<GuildResponse>,
    val pagination: Pagination,
) {

    data class Pagination(
        val totalRecords: Int,
        val currentPage: Int,
        val totalPages: Int,
        val nextPage: Int?,
        val prevPage: Int?,
    )

    companion object {
        
        fun from(guilds: Page<Guild>, forceCurrentPage: Int): GuildPagingResponse {
            return GuildPagingResponse(
                guilds = guilds.map { GuildResponse.from(it) }.toList(),
                pagination = Pagination(
                    totalRecords = guilds.count(),
                    currentPage = forceCurrentPage,
                    totalPages = guilds.totalPages,
                    nextPage = when (guilds.hasNext()) {
                        true -> guilds.number + 1
                        false -> null
                    },
                    prevPage = when (guilds.hasPrevious()) {
                        true -> guilds.number - 1
                        false -> null
                    },
                )
            )
        }
    }
}
