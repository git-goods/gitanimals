package org.gitanimals.render.domain.event

import java.time.ZonedDateTime

data class UserYesterdayReport(
    val date: ZonedDateTime,
    val yesterdayNewUserCount: Int,
    val totalUserCount: Long,
    val serverName: String,
)
