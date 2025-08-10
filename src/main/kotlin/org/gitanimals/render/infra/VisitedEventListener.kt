package org.gitanimals.render.infra

import org.gitanimals.core.IdGenerator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.render.app.ContributionApi
import org.gitanimals.render.app.IdentityApi
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.*
import org.rooftop.netx.meta.SagaHandler
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.context.event.EventListener
import org.springframework.dao.CannotAcquireLockException
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
            MDC.put(TRACE_ID, visited.traceId)
            val username = visited.username
            userService.increaseVisit(username)

            logger.info("[VisitedEventListener] Increase visit to user. username: \"$username\"")

            if (userService.isContributionUpdatedLongAgo(username).not()) {
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
            logger.info("[VisitedEventListener] Increase point to user. username: \"$username\", point:\"${increaseContributionCount * 100}\"")
        }.onFailure {
            if (it !is IllegalArgumentException) {
                logger.error(
                    "[VisitedEventListener] Cannot increase visit or point to user. username: \"${visited.username}\"", it
                )
            }
            if (it !is CannotAcquireLockException) {
                logger.warn("[VisitedEventListener] Deadlock found.", it)
            }
        }.also {
            MDC.remove(TRACE_ID)
        }
    }
}
