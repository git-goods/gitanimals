package org.gitanimals.render.infra.event

import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.redis.AsyncRedisPubSubEvent
import org.gitanimals.core.redis.RedisPubSubChannel.NEW_PET_DROP_RATE_DISTRIBUTION
import org.slf4j.MDC

data class NewPetDropRateDistributionEvent(
    val type: Type,
    val distributions: List<Distribution>,
) : AsyncRedisPubSubEvent(
    traceId = MDC.get(TRACE_ID),
    channel = NEW_PET_DROP_RATE_DISTRIBUTION,
) {
    data class Distribution(
        val dropRate: Double,
        val count: Int,
    )
}

enum class Type {
    DAILY,
    WEEKLY,
    MONTHLY,
}
