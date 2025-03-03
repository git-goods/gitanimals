package org.gitanimals.rank.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface GuildContributionRankRepository : JpaRepository<GuildContributionRank, Long> {

    fun findByGuildId(guildId: Long): GuildContributionRank?

    @Modifying
    @Query("update GuildContributionRank as g set g.weeklyContributions = 0")
    fun initialWeeklyRanks()
}
