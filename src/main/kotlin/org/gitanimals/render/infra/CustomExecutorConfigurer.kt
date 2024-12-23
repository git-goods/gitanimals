package org.gitanimals.render.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import kotlin.time.Duration.Companion.minutes

@Configuration
class CustomExecutorConfigurer {

    @Bean(GRACEFUL_SHUTDOWN_EXECUTOR)
    fun taskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2
        executor.maxPoolSize = 20
        executor.threadNamePrefix = "$GRACEFUL_SHUTDOWN_EXECUTOR-"
        executor.setWaitForTasksToCompleteOnShutdown(true)
        executor.setAwaitTerminationSeconds(2.minutes.inWholeSeconds.toInt())
        executor.initialize()

        return executor
    }

    companion object {
        const val GRACEFUL_SHUTDOWN_EXECUTOR = "gracefulShutdownExecutor"
    }
}
