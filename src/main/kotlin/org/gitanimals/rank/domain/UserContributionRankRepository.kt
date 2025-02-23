package org.gitanimals.rank.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserContributionRankRepository : JpaRepository<UserContributionRank, Long> {
    fun findByUserId(userId: Long): UserContributionRank?
}
