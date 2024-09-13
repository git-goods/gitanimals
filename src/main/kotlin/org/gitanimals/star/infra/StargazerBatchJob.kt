package org.gitanimals.star.infra

import org.gitanimals.star.domain.StargazerService
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class StargazerBatchJob(
    private val githubStargazerApi: GithubStargazerApi,
    private val stargazerService: StargazerService,
) {

    @EventListener(ApplicationStartedEvent::class)
    fun initStargazer() {
        updateStargazer()
    }

    @Scheduled(cron = EVERY_DAY)
    fun updateStargazer() {
        val stargazers = githubStargazerApi.getStargazers()
        stargazerService.updateAll(
            stargazers.flatMap { stargazer ->
                stargazer.edges.map { edge ->
                    edge.node.login
                }
            }
        )
    }


    companion object {
        private const val EVERY_DAY = "0 0 * * * ?"
    }
}
