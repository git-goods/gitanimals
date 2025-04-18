package org.gitanimals.render.app

import org.gitanimals.core.Mode
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.render.domain.User
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.NewUserCreated
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.SagaManager
import org.slf4j.MDC
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientException

@Service
class AnimationFacade(
    private val userService: UserService,
    private val contributionApi: ContributionApi,
    private val sagaManager: SagaManager,
    private val eventPublisher: ApplicationEventPublisher,
) {

    fun getFarmAnimation(username: String): String {
        return when (userService.existsByName(username)) {
            true -> {
                val svgAnimation = userService.getFarmAnimationByUsername(username)
                eventPublisher.publishEvent(Visited(username, MDC.get(TRACE_ID)))
                svgAnimation
            }

            false -> {
                val user = createNewUser(username)
                sagaManager.startSync(NewUserCreated(user.id, user.name))
                userService.getFarmAnimationByUsername(user.name)
            }
        }
    }

    fun getLineAnimation(username: String, personaId: Long, mode: Mode): String {
        return when (userService.existsByName(username)) {
            true -> {
                val svgAnimation = userService.getLineAnimationByUsername(username, personaId, mode)
                eventPublisher.publishEvent(Visited(username, MDC.get(TRACE_ID)))
                svgAnimation
            }

            false -> {
                val user = createNewUser(username)
                sagaManager.startSync(NewUserCreated(user.id, user.name))
                userService.getLineAnimationByUsername(user.name, personaId, mode)
            }
        }
    }

    fun createNewUser(username: String): User {
        return runCatching {
            val contributionYears = contributionApi.getAllContributionYears(username)
            val contributionCountPerYear =
                contributionApi.getContributionCount(username, contributionYears)
            userService.createNewUser(username, contributionCountPerYear)
        }.getOrElse {
            require(it !is RestClientException) { "Cannot create new user from username \"$username\"" }
            throw it
        }
    }
}
