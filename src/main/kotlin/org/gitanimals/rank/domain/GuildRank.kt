package org.gitanimals.rank.domain

import jakarta.persistence.Column

class GuildRank(
    id: Long,
    order: Long,

    @Column(name = "guildId", nullable = false, unique = true)
    val guildId: Long,
    @Column(name = "totalContributions", nullable = false)
    val totalContributions: Long,
) : Rank(id, order)
