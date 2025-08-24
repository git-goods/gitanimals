package org.gitanimals.core.lock

import org.springframework.stereotype.Component
import kotlin.time.Duration.Companion.seconds

object LOCK_KEY_PREFIX {
    const val CREATE_NEW_USER = "CREATE_NEW_USER"
    const val SET_AUTH = "SET_AUTH"
}

object DistributedLock {

    private lateinit var lockService: DistributedLockService

    fun <T> withLock(
        key: String,
        leaseMillis: Long = 10.seconds.inWholeMilliseconds,
        waitMillis: Long = 3.seconds.inWholeMilliseconds,
        whenAcquireFailed : () -> T = throw LockAcquireFailException(message = "Cannot acquire lock"),
        action: () -> T,
    ): T {
        return lockService.withLock(
            key = key,
            leaseMillis = leaseMillis,
            waitMillis = waitMillis,
            action = action,
            whenAcquireFail = whenAcquireFailed,
        )
    }

    interface DistributedLockService {

        fun <T> withLock(
            key: String,
            leaseMillis: Long = 10.seconds.inWholeMilliseconds,
            waitMillis: Long = 3.seconds.inWholeMilliseconds,
            whenAcquireFail : () -> T = throw LockAcquireFailException(message = "Cannot acquire lock"),
            action: () -> T,
        ): T
    }

    @Component
    class DistributedLockServiceInjector(distributedLockService: DistributedLockService) {

        init {
            lockService = distributedLockService
        }
    }
}
