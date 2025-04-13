package org.gitanimals.core.redis

import com.fasterxml.jackson.annotation.JsonIgnore
import org.gitanimals.core.filter.MDCFilter
import org.slf4j.MDC

abstract class AsyncRedisPubSubEvent(
    val apiUserId: String? = runCatching { MDC.get(MDCFilter.USER_ID) }.getOrNull(),
    val traceId: String,
    @JsonIgnore
    val channel: String,
)
