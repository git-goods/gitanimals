package org.gitanimals.guild.app

import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.RandomGuildCache
import org.gitanimals.guild.domain.SearchFilter
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class SearchGuildFacade(
    private val randomGuildCache: RandomGuildCache,
    private val guildService: GuildService,
) {

    fun search(key: Int, text: String, pageNumber: Int, filter: SearchFilter): Page<Guild> {
        if (filter == SearchFilter.RANDOM) {
            return randomGuildCache.get(
                key = key,
                text = text,
                pageNumber = pageNumber,
                filter = filter,
            )
        }

        return guildService.search(
            text = text,
            pageNumber = pageNumber,
            filter = filter,
        )
    }
}
