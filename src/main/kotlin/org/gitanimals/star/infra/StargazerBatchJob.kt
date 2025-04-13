package org.gitanimals.star.infra

import org.gitanimals.star.domain.StargazerService
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@Profile("!test")
class StargazerBatchJob(
    private val githubStargazerApi: GithubStargazerApi,
    private val stargazerService: StargazerService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @EventListener(ApplicationStartedEvent::class)
    fun initStargazer() {
        updateStargazer()
    }

    @Scheduled(cron = EVERY_DAY)
    fun updateStargazer() {
        runCatching {
            val stargazers = githubStargazerApi.getStargazers()
            stargazerService.updateAll(
                stargazers.flatMap { stargazer ->
                    stargazer.edges.map { edge ->
                        edge.node.login
                    }
                }
            )
        }.onSuccess {
            logger.info("[StargazerBatchJob] Success to aggregation stargazer counts.")
        }.onFailure {
            logger.error(
                "[StargazerBatchJob] Fail to aggregation stargazer counts. cause: ${it.message}",
                it
            )
        }
    }


    companion object {
        private const val EVERY_DAY = "0 0 * * * ?"
    }
}
