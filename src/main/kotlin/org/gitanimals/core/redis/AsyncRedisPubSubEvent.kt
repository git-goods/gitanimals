package org.gitanimals.core.redis

import com.fasterxml.jackson.annotation.JsonIgnore

abstract class AsyncRedisPubSubEvent(
    val traceId: String,
    @JsonIgnore
    val channel: String,
)
