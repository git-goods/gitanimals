package org.gitanimals.supports.deadletter

import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter
import org.gitanimals.core.redis.AsyncRedisPubSubEvent
import org.gitanimals.core.redis.RedisPubSubChannel.DEAD_LETTER_OCCURRED
import org.slf4j.MDC

data class DeadLetterEvent(
    val deadLetterId: String,
    val sagaId: String,
    val nodeName: String,
    val group: String,
    val deadLetter: Map<String, Any>,
) : AsyncRedisPubSubEvent(
    traceId = runCatching { MDC.get(MDCFilter.TRACE_ID) }
        .getOrElse { IdGenerator.generate().toString() },
    channel = DEAD_LETTER_OCCURRED,
)
