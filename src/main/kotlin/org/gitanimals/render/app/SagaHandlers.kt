package org.gitanimals.render.app

import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.*
import org.rooftop.netx.meta.SagaHandler
import java.time.ZoneId
import java.time.ZonedDateTime

@SagaHandler
class SagaHandlers(
    private val userService: UserService,
    private val contributionApi: ContributionApi,
) {

    @SagaStartListener(event = Visited::class, successWith = SuccessWith.PUBLISH_COMMIT)
    fun increaseUserVisited(sagaStartEvent: SagaStartEvent) {
        val visited = sagaStartEvent.decodeEvent(Visited::class)
        val username = visited.username
        userService.increaseVisit(username)
        sagaStartEvent.setNextEvent(visited)
    }

    @SagaCommitListener(event = Visited::class)
    fun updateUserContributions(sagaCommitEvent: SagaCommitEvent) {
        val visited = sagaCommitEvent.decodeEvent(Visited::class)
        val username = visited.username
        if (!userService.isContributionUpdatedBeforeOneHour(username)) {
            return
        }

        val currentYear = ZonedDateTime.now(ZoneId.of("UTC")).year
        val contribution =
            contributionApi.getContributionCount(username, listOf(currentYear))[currentYear]
                ?: throw NullPointerException("Empty contribution current year \"$currentYear\"")

        userService.updateContributions(username, contribution)
    }
}
