package org.gitanimals.render.app

import org.gitanimals.render.domain.User
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.SagaManager
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientException

@Service
class AnimationFacade(
    private val userService: UserService,
    private val contributionApi: ContributionApi,
    private val sagaManager: SagaManager,
) {

    fun getFarmAnimation(username: String): String {
        return when (userService.existsByName(username)) {
            true -> {
                val svgAnimation = userService.getFarmAnimationByUsername(username)
                sagaManager.startSync(Visited(username))
                svgAnimation
            }

            false -> {
                val user = createNewUser(username)
                userService.getFarmAnimationByUsername(user.name)
            }
        }
    }

    fun getLineAnimation(username: String, personaId: Long): String {
        return when (userService.existsByName(username)) {
            true -> {
                val svgAnimation = userService.getLineAnimationByUsername(username, personaId)
                sagaManager.startSync(Visited(username))
                svgAnimation
            }

            false -> {
                val user = createNewUser(username)
                userService.getLineAnimationByUsername(user.name, personaId)
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
