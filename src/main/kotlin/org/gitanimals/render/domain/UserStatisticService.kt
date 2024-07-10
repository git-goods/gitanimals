package org.gitanimals.render.domain

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneOffset

@Service
class UserStatisticService(
    private val userStatisticRepository: UserStatisticRepository,
) {

    fun getYesterdayUserCount(): Int {
        val current = LocalDate.now()
        val startDay = current.atTime(0, 0, 0).toInstant(ZoneOffset.UTC)
        val endDay = current.atTime(23, 59, 59).toInstant(ZoneOffset.UTC)
        return userStatisticRepository.getDailyUserCount(startDay, endDay)
    }

    fun getTotalUserCount(): Long = userStatisticRepository.count()
}
