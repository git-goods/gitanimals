package org.gitanimals.core.redis

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.context.ApplicationEvent

abstract class TransactionCommitRedisPubSubEvent(
    @JsonIgnore
    val channel: String,
    source: Any,
) : ApplicationEvent(source) {

    @JsonIgnore
    override fun getSource(): Any {
        return super.source
    }
}
