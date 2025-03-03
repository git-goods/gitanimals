package org.gitanimals.rank.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserContributionRankRepository : JpaRepository<UserContributionRank, Long> {
    fun findByUserId(userId: Long): UserContributionRank?

    @Query("select u from UserContributionRank as u where u.username = :username")
    fun findByUsername(@Param("username") username: String): UserContributionRank?

    @Modifying
    @Query("update UserContributionRank as u set u.weeklyContributions = 0")
    fun initialWeeklyRanks()
}
