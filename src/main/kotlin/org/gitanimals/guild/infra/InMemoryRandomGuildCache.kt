package org.gitanimals.guild.infra

import org.gitanimals.guild.domain.Guild
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.GuildService.Companion.PAGE_SIZE
import org.gitanimals.guild.domain.RandomGuildCache
import org.gitanimals.guild.domain.SearchFilter
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class InMemoryRandomGuildCache(
    private val guildService: GuildService,
) : RandomGuildCache {

    private lateinit var cache: Map<Int, List<Guild>>

    override fun get(key: Int, text: String, pageNumber: Int, filter: SearchFilter): Page<Guild> {
        if (MAX_PAGE <= pageNumber) {
            return guildService.search(
                text = text,
                pageNumber = pageNumber,
                filter = filter,
            )
        }

        val guilds = cache[key % MAX_KEY]
            ?: throw IllegalStateException("Cannot find random guild data from key \"$key\"")

        val filteredGuilds = guilds.filter {
            if (text.isBlank()) {
                true
            } else {
                it.getTitle().contains(text) or it.getBody().contains(text)
            }
        }

        val response = mutableListOf<Guild>()

        repeat(PAGE_SIZE) {
            val idx = it + pageNumber * PAGE_SIZE

            if (filteredGuilds.size <= idx) {
                return@repeat
            }

            response.add(filteredGuilds[idx])
        }

        return PageImpl(filter.sort(response), Pageable.ofSize(PAGE_SIZE), guilds.size.toLong())
    }

    @Scheduled(cron = ONCE_0AM_TIME)
    @EventListener(ContextRefreshedEvent::class)
    fun updateRandom() {
        val guilds = guildService.findAllWithLimit(LIMIT)

        val updateCache = mutableMapOf<Int, List<Guild>>()
        repeat(MAX_KEY) { updateCache[it] = guilds.shuffled() }

        cache = updateCache
    }

    companion object {
        private const val MAX_KEY = 3
        private const val ONCE_0AM_TIME = "0 0 0/1 * * ?"
        private const val LIMIT = PAGE_SIZE * 10
        private const val MAX_PAGE = LIMIT / PAGE_SIZE
    }
}
