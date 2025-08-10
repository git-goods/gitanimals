package org.gitanimals.core.ratelimit

import org.gitanimals.core.instant
import java.time.Instant
import java.time.LocalDateTime

interface RateLimitable {

    fun <T> acquire(limitPercent: Double = 0.0, action: suspend (RateLimit?) -> T): T

    fun update(rateLimit: RateLimit)

    data class RateLimit(
        val limit: Int,
        val remaining: Int,
        val resetAt: LocalDateTime,
        val used: Int,
        val requestedAt: Instant = instant(),
    ) {
        fun getRemainPercentage(): Double {
            val percentage = (remaining.toDouble() / limit.toDouble()) * 100.0
            return percentage.coerceIn(0.0, 100.0)
        }
    }
}
