package org.gitanimals.render.app

import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.SagaStartEvent
import org.rooftop.netx.api.SagaStartListener
import org.rooftop.netx.api.SuccessWith
import org.rooftop.netx.meta.SagaHandler

@SagaHandler
class VisitSagaHandler(
    private val userService: UserService,
) {

    @SagaStartListener(event = Visited::class, successWith = SuccessWith.PUBLISH_COMMIT)
    fun increaseUserVisited(sagaStartEvent: SagaStartEvent) {
        val username = sagaStartEvent.decodeEvent(Visited::class).username
        userService.increaseVisit(username)
    }
}
