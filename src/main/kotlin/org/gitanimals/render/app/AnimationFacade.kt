package org.gitanimals.render.app

import jakarta.annotation.PostConstruct
import org.gitanimals.render.domain.User
import org.gitanimals.render.domain.UserService
import org.rooftop.netx.api.Orchestrator
import org.rooftop.netx.api.OrchestratorFactory
import org.springframework.stereotype.Service


@Service
class AnimationFacade(
    private val api: Api,
    private val userService: UserService,
    private val orchestratorFactory: OrchestratorFactory,
) {

    private lateinit var registerNewUserOrchestrator: Orchestrator<String, User>

    fun getSvgAnimationByUsername(username: String): String {
        return when (userService.existsByName(username)) {
            true -> userService.getUserByName(username)
            false -> registerNewUserOrchestrator.sagaSync(10000, username)
                .decodeResultOrThrow(User::class)
        }.createSvgAnimation()
    }

    @PostConstruct
    fun registerNewUserOrchestrator() {
        registerNewUserOrchestrator = orchestratorFactory.create<String>("register new user")
            .start(orchestrate = {
                userService.createNewUser(it)
            })
            .commit(
                orchestrate = { user ->
                    api.createNewUser(user)
                    user
                }
            )
    }
}
