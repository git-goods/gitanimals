package org.gitanimals.render.infra

import org.gitanimals.core.IdGenerator
import org.gitanimals.render.app.ContributionApi
import org.gitanimals.render.app.IdentityApi
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.*
import org.rooftop.netx.meta.SagaHandler
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import java.time.ZoneId
import java.time.ZonedDateTime

@SagaHandler
class VisitedEventListener(
    private val userService: UserService,
    private val contributionApi: ContributionApi,
    private val identityApi: IdentityApi,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Async
    @EventListener(Visited::class)
    fun increaseUserVisited(visited: Visited) {
        runCatching {
            val username = visited.username
            userService.increaseVisit(username)

            logger.info("Increase visit to user. username: \"$username\"")

            if (!userService.isContributionUpdatedBeforeOneHour(username)) {
                return
            }

            val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
            val contribution =
                contributionApi.getContributionCount(username, listOf(currentYear))[currentYear]
                    ?: throw NullPointerException("Empty contribution current year \"$currentYear\"")

            val increaseContributionCount = userService.updateContributions(username, contribution)
            identityApi.increaseUserPointsByUsername(
                username = username,
                point = increaseContributionCount * 100,
                idempotencyKey = IdGenerator.generate().toString(),
            )
            logger.info("Increase point to user. username: \"$username\", point:\"${increaseContributionCount * 100}\"")
        }.onFailure {
            logger.error("Cannot increase visit or point to user. username: \"${visited.username}\"", it)
        }
    }
}
