package org.gitanimals.guild.domain

import org.springframework.data.domain.Page

fun interface RandomGuildCache {

    fun get(key: Int, text: String, pageNumber: Int, filter: SearchFilter): Page<Guild>
}