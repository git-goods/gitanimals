package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.Instant

interface UserStatisticRepository : JpaRepository<User, Long> {

    @Query("select count(u.id) from user u where u.createdAt between :startDay and :endDay")
    fun getDailyUserCount(
        @Param("startDay") startDay: Instant,
        @Param("endDay") endDay: Instant,
    ): Int
}
