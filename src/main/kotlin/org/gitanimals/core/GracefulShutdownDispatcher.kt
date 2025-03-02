package org.gitanimals.core

import jakarta.annotation.PreDestroy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import org.gitanimals.core.GracefulShutdownDispatcher.executorService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object GracefulShutdownDispatcher {

    val executorService = Executors.newFixedThreadPool(10) { runnable ->
        Thread(runnable, "gitanimals-gracefulshutdown").apply { isDaemon = false }
    }

    val dispatcher: CoroutineDispatcher = executorService.asCoroutineDispatcher()
}

@Component
class GracefulShutdownHook {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @PreDestroy
    fun tryGracefulShutdown() {
        logger.info("Shutting down dispatcher...")
        executorService.shutdown()
        runCatching {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                logger.warn("Forcing shutdown...")
                executorService.shutdownNow()
            } else {
                logger.info("Shutdown completed gracefully.")
            }
        }.onFailure {
            if (it is InterruptedException) {
                logger.warn("Shutdown interrupted. Forcing shutdown...")
                executorService.shutdownNow()
                Thread.currentThread().interrupt()
            }
        }
    }
}
