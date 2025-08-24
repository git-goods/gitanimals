package org.gitanimals.render.app

import org.gitanimals.core.Mode
import org.gitanimals.core.UpdateUserOrchestrator
import org.gitanimals.core.auth.UserEntryPoint
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.lock.DistributedLock
import org.gitanimals.core.lock.LOCK_KEY_PREFIX.CREATE_NEW_USER
import org.gitanimals.render.domain.EntryPoint
import org.gitanimals.render.domain.User
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.event.NewUserCreated
import org.gitanimals.render.domain.event.Visited
import org.rooftop.netx.api.SagaManager
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientException

@Service
class AnimationFacade(
    private val userService: UserService,
    private val updateUserOrchestrator: UpdateUserOrchestrator,
    private val contributionApi: ContributionApi,
    private val sagaManager: SagaManager,
    private val eventPublisher: ApplicationEventPublisher,
    private val githubRestApi: GithubRestApi,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    fun getFarmAnimation(username: String): String {
        return when (userService.existsByName(username)) {
            true -> {
                setUserAuthInfoIfNotSet(username)

                val svgAnimation = userService.getFarmAnimationByUsername(username)
                eventPublisher.publishEvent(Visited(username, MDC.get(TRACE_ID)))
                svgAnimation
            }

            false -> {
                val user = createOrUpdateUser(username)
                userService.getFarmAnimationByUsername(user.getName())
            }
        }
    }

    fun getLineAnimation(username: String, personaId: Long, mode: Mode): String {
        return when (userService.existsByName(username)) {
            true -> {
                setUserAuthInfoIfNotSet(username)

                val svgAnimation = userService.getLineAnimationByUsername(username, personaId, mode)
                eventPublisher.publishEvent(Visited(username, MDC.get(TRACE_ID)))
                svgAnimation
            }

            false -> {
                val user = createOrUpdateUser(username)
                userService.getLineAnimationByUsername(user.getName(), personaId, mode)
            }
        }
    }

    private fun createOrUpdateUser(username: String): User {
        val githubUserAuthInfo = githubRestApi.getGithubUser(username)

        val existsUser = userService.findUserByEntryPointAndAuthenticationId(
            entryPoint = EntryPoint.GITHUB,
            authenticationId = githubUserAuthInfo.id,
        ) ?: return createNewUser(username)

        if (existsUser.getName() != username) {
            updateUserOrchestrator.updateUsername(
                UpdateUserOrchestrator.UpdateUserNameRequest(
                    id = existsUser.id,
                    authenticationId = existsUser.getAuthenticationId(),
                    previousName = existsUser.getName(),
                    changeName = username,
                    entryPoint = UserEntryPoint.GITHUB,
                )
            )
        }

        return userService.getUserByName(username)
    }

    private fun createNewUser(username: String): User {
        return DistributedLock.withLock(
            key = "$CREATE_NEW_USER:$username",
            whenAcquireFailed = { userService.getUserByName(username) }
        ) {
            runCatching {
                val contributionYears = contributionApi.getAllContributionYears(username)
                val contributionCountPerYear =
                    contributionApi.getContributionCount(username, contributionYears)

                userService.createNewUser(
                    name = username,
                    contributions = contributionCountPerYear,
                )
            }.onSuccess {
                setUserAuthInfoIfNotSet(username)
                sagaManager.startSync(NewUserCreated(it.id, it.getName()))
            }.getOrElse {
                require(it !is RestClientException) { "Cannot create new user from username \"$username\"" }
                throw it
            }
        }
    }

    private fun setUserAuthInfoIfNotSet(username: String) {
        runCatching {
            val user = userService.getUserByName(username)

            if (user.isAuthInfoSet().not()) {
                val githubUserAuthInfo = githubRestApi.getGithubUser(user.getName())
                userService.setAuthInfo(
                    name = user.getName(),
                    entryPoint = EntryPoint.GITHUB,
                    authenticationId = githubUserAuthInfo.id,
                )
            }
        }.onFailure {
            logger.info("Fail to update userAuthInfo cause: ${it.message}", it)
        }
    }
}
