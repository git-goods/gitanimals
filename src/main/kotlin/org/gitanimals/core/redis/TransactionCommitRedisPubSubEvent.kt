package org.gitanimals.core.redis

import com.fasterxml.jackson.annotation.JsonIgnore
import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.slf4j.MDC
import org.springframework.context.ApplicationEvent

abstract class TransactionCommitRedisPubSubEvent(
    val traceId: String = runCatching { MDC.get(TRACE_ID) }.getOrElse {
        IdGenerator.generate().toString()
    },
    @JsonIgnore
    val channel: String,
    source: Any,
) : ApplicationEvent(source) {

    @JsonIgnore
    override fun getSource(): Any {
        return super.source
    }
}
