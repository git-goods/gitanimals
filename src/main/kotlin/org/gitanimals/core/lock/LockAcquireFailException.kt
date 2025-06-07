package org.gitanimals.core.lock

class LockAcquireFailException(
    override val message: String,
) : RuntimeException(message)
