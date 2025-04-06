package org.gitanimals.supports.event

import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.redis.AsyncRedisPubSubEvent
import org.gitanimals.core.redis.RedisPubSubChannel
import org.slf4j.MDC

data class SlackReplied(
    val slackChannel: String,
    val threadTs: String,
    val message: String,
) : AsyncRedisPubSubEvent(
    channel = RedisPubSubChannel.SLACK_REPLIED,
    traceId = runCatching { MDC.get(TRACE_ID) }
        .getOrElse { IdGenerator.generate().toString() },
)
