package org.gitanimals.rank.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.gitanimals.core.IdGenerator

@Entity
@Table(name = "user_contribution_rank")
class UserContributionRank(
    id: Long,
    image: String,

    @Column(name = "user_id", nullable = false, unique = true)
    val userId: Long,
    @Column(name = "username", nullable = false, unique = true)
    val username: String,
    @Column(name = "total_contributions", nullable = false)
    var totalContributions: Long,
) : Rank(id, image) {

    companion object {

        fun create(
            image: String,
            userId: Long,
            username: String,
            totalContributions: Long,
        ): UserContributionRank {
            return UserContributionRank(
                id = IdGenerator.generate(),
                image = image,
                userId = userId,
                username = username,
                totalContributions = totalContributions,
            )
        }
    }
}
