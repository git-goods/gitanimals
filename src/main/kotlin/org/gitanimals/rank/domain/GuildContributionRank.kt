package org.gitanimals.rank.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.gitanimals.core.IdGenerator

@Entity
@Table(name = "guild_contribution_rank")
class GuildContributionRank(
    id: Long,
    image: String,

    @Column(name = "guild_id", nullable = false, unique = true)
    val guildId: Long,
    @Column(name = "guild_name", nullable = false, unique = true)
    val guildName: String,
    @Column(name = "weekly_contributions", nullable = false)
    var weeklyContributions: Long,
) : Rank(id, image) {

    companion object {
        fun create(
            image: String,
            guildId: Long,
            guildName: String,
            weeklyContributions: Long,
        ): GuildContributionRank {
            return GuildContributionRank(
                id = IdGenerator.generate(),
                image = image,
                guildId = guildId,
                guildName = guildName,
                weeklyContributions = weeklyContributions,
            )
        }
    }
}
