package org.gitanimals.supports.ratelimit

import jakarta.annotation.PreDestroy
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import org.gitanimals.core.ratelimit.RateLimitable
import org.gitanimals.core.slack.SlackSender
import org.gitanimals.supports.ratelimit.InmemoryGithubRateLimiter.CoroutineDispatcher.coroutineContext
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

@Component
class InmemoryGithubRateLimiter(
    private val slackSender: SlackSender,
) : RateLimitable {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)
    private var rateLimit: RateLimitable.RateLimit? = null
    private val getSemaphoreByRateLimit: (RateLimitable.RateLimit) -> Semaphore? = { rateLimit ->
        when {
            rateLimit.getRemainPercentage() >= 80.0 -> null // Do not limit
            rateLimit.getRemainPercentage() >= 50.0 -> semaphore50
            rateLimit.getRemainPercentage() >= 20.0 -> semaphore30
            rateLimit.getRemainPercentage() >= 0.0 -> semaphore20
            else -> {
                logger.warn("[InmemoryGithubRateLimiter] Cannot find any semaphore rules.")
                null
            }
        }
    }

    private val semaphore50 = Semaphore(50)
    private val semaphore30 = Semaphore(30)
    private val semaphore20 = Semaphore(20)
    private val lock = Any()

    private val githubTokenChannel = "C099RAJA1ML"

    override fun <T> acquire(limitPercent: Double, action: suspend (RateLimitable.RateLimit?) -> T): T {
        val fixedRateLimit = rateLimit

        if (fixedRateLimit != null && fixedRateLimit.getRemainPercentage() < limitPercent) {
            val message = """
                Rate limit in effect…
                Skipping execution because the remaining ${fixedRateLimit.getRemainPercentage()} is lower than $limitPercent.
            """.trimIndent()

            slackSender.send(channel = githubTokenChannel, message = message)

            throw IllegalStateException(message)
        }

        val semaphore = fixedRateLimit?.let {
            getSemaphoreByRateLimit.invoke(it)
        }

        return runBlocking(coroutineContext) {
            if (semaphore == null) {
                return@runBlocking action(fixedRateLimit)
            }

            semaphore.withPermit { action(fixedRateLimit) }
        }
    }

    override fun findRateLimit(): RateLimitable.RateLimit? = rateLimit

    override fun update(rateLimit: RateLimitable.RateLimit) {
        synchronized(lock) {
            this.rateLimit?.let {
                if (it.requestedAt <= rateLimit.requestedAt) {
                    this.rateLimit = rateLimit
                }
            } ?: run {
                this.rateLimit = rateLimit
            }
            if (rateLimit.getRemainPercentage() < 20.0) {
                val message = """
                    :warning: Warning! 
                    Remaining token quota is below 20%.
                    ---
                    $rateLimit
                """.trimIndent()

                slackSender.send(githubTokenChannel, message)
            }
        }
    }

    @Scheduled(cron = "0 0 * * * *", zone = "Asia/Seoul")
    fun sendRateLimitAlert() {
        val message = """
            :pirate_flag: Current github rate limit
            
            $rateLimit
        """.trimIndent()
        slackSender.send(githubTokenChannel, message)
    }

    object CoroutineDispatcher {

        private val executorService = Executors.newCachedThreadPool { runnable ->
            Thread(runnable, "github-ratelimit-graceful-shutdown").apply { isDaemon = false }
        }

        val coroutineContext: CoroutineContext =
            executorService.asCoroutineDispatcher() + MDCContext()

        @Component
        class GithubRateLimitGracefulShutdownHook {

            private val logger = LoggerFactory.getLogger(this::class.simpleName)

            @PreDestroy
            fun tryGracefulShutdown() {
                logger.info("[GithubRateLimitGracefulShutdownHook] Shutting down dispatcher...")
                executorService.shutdown()
                runCatching {
                    if (!executorService.awaitTermination(180, TimeUnit.SECONDS)) {
                        logger.warn("[GithubRateLimitGracefulShutdownHook] Forcing shutdown...")
                        executorService.shutdownNow()
                    } else {
                        logger.info("[GithubRateLimitGracefulShutdownHook] Shutdown completed gracefully.")
                    }
                }.onFailure {
                    if (it is InterruptedException) {
                        logger.warn("[GithubRateLimitGracefulShutdownHook] Shutdown interrupted. Forcing shutdown...")
                        executorService.shutdownNow()
                        Thread.currentThread().interrupt()
                    }
                }
            }
        }
    }
}
