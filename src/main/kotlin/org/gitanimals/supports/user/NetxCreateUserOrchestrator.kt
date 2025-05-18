package org.gitanimals.supports.user

import org.gitanimals.core.CreateUserOrchestrator
import org.gitanimals.core.CreateUserOrchestrator.CreateUserRequest
import org.gitanimals.core.TraceIdContextOrchestrator
import org.gitanimals.render.app.ContributionApi
import org.gitanimals.render.domain.UserService
import org.rooftop.netx.api.OrchestratorFactory
import org.springframework.stereotype.Component

@Component
class NetxCreateUserOrchestrator(
    orchestratorFactory: OrchestratorFactory,

    private val userService: UserService,
    private val contributionApi: ContributionApi
) : CreateUserOrchestrator {

    private val orchestrator =
        orchestratorFactory.create<CreateUserRequest>("create user orchestrator")
            .startWithContext(
                contextOrchestrate = TraceIdContextOrchestrator { _, request ->
                    val contributionYears =
                        contributionApi.getAllContributionYears(request.username)
                    val contributionCountPerYear =
                        contributionApi.getContributionCount(request.username, contributionYears)

                    userService.createNewUser(request.username, contributionCountPerYear)
                },
                contextRollback = { _, request ->
                    userService.deleteByName(request.username)
                }
            ).

    override fun create(request: CreateUserRequest) {

    }
}
