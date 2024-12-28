package org.gitanimals.render.app

import org.gitanimals.core.instant
import org.gitanimals.core.toKr
import org.gitanimals.render.domain.UserStatisticService
import org.gitanimals.render.domain.event.UserYesterdayReport
import org.rooftop.netx.api.SagaManager
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class UserStatisticSchedule(
    private val sagaManager: SagaManager,
    private val userStatisticService: UserStatisticService,
) {

    @Scheduled(cron = EVERY_9AM, zone = "Asia/Seoul")
    fun sendYesterdayNewUserReport() {
        val yesterday = instant().toKr().minusDays(1)
        val yesterdayUserCount = userStatisticService.getYesterdayUserCount()
        val totalUserCount = userStatisticService.getTotalUserCount()

        val userYesterdayReport = UserYesterdayReport(
            date = yesterday,
            yesterdayNewUserCount = yesterdayUserCount,
            totalUserCount = totalUserCount,
            serverName = SERVER_NAME,
        )

        sagaManager.startSync(userYesterdayReport)
    }

    private companion object {
        private const val EVERY_9AM = "0 0 9 * * ?"
        private const val SERVER_NAME = "RENDER"
    }
}
