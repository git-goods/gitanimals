package org.gitanimals.render.saga

import org.gitanimals.render.app.ContributionApi
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.gitanimals.render.saga.event.GavePoint
import org.rooftop.netx.api.*
import org.rooftop.netx.meta.SagaHandler
import java.time.ZoneId
import java.time.ZonedDateTime

@SagaHandler
class VisitedSagaHandlers(
    private val userService: UserService,
    private val contributionApi: ContributionApi,
) {

    @SagaStartListener(event = Visited::class, successWith = SuccessWith.PUBLISH_JOIN)
    fun increaseUserVisited(sagaStartEvent: SagaStartEvent) {
        val visited = sagaStartEvent.decodeEvent(Visited::class)
        val username = visited.username
        userService.increaseVisit(username)
        sagaStartEvent.setNextEvent(visited)
    }

    @SagaJoinListener(
        event = Visited::class,
        successWith = SuccessWith.PUBLISH_COMMIT,
        noRollbackFor = [NullPointerException::class]
    )
    fun updateUserContributions(sagaJoinEvent: SagaJoinEvent) {
        val visited = sagaJoinEvent.decodeEvent(Visited::class)
        val username = visited.username
        if (!userService.isContributionUpdatedBeforeOneHour(username)) {
            return
        }

        val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
        val contribution =
            contributionApi.getContributionCount(username, listOf(currentYear))[currentYear]
                ?: throw NullPointerException("Empty contribution current year \"$currentYear\"")

        val increaseContributionCount = userService.updateContributions(username, contribution)

        sagaJoinEvent.setNextEvent(
            GavePoint(username = username, point = (increaseContributionCount * 100).toLong())
        )
    }
}
