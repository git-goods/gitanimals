package org.gitanimals.rank.domain

import org.springframework.data.jpa.repository.JpaRepository

interface GuildContributionRankRepository : JpaRepository<GuildContributionRank, Long> {

    fun findByGuildId(guildId: Long): GuildContributionRank?
}
