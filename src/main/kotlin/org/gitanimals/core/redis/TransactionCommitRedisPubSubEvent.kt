package org.gitanimals.core.redis

import org.springframework.context.ApplicationEvent

abstract class TransactionCommitRedisPubSubEvent(
    channel: String,
    source: Any,
) : ApplicationEvent(source)
