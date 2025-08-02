package org.gitanimals.supports.orchestrate

import org.gitanimals.core.TraceIdContextOrchestrator
import org.gitanimals.core.TraceIdContextRollback
import org.gitanimals.core.UpdateUserOrchestrator
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.lock.DistributedLock
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.render.domain.UserService
import org.rooftop.netx.api.OrchestratorFactory
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import kotlin.time.Duration.Companion.seconds

@Component
class NetxUserOrchestrator(
    orchestratorFactory: OrchestratorFactory,

    private val userService: UserService,
    private val userContributionRankService: UserContributionRankService,
    private val guildService: GuildService,
    private val identityApi: IdentityApi,
) : UpdateUserOrchestrator {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    private val orchestrator = orchestratorFactory
        .create<UpdateUserOrchestrator.UpdateUserNameRequest>(
            "update username orchestrator"
        ).startWithContext(
            contextOrchestrate = TraceIdContextOrchestrator { _, request ->
                userService.updateUsernameById(request.id, request.changeName)
                request
            },
            contextRollback = TraceIdContextRollback { _, request ->
                logger.warn("Fail to update user name. rollback start user-info id: \"${request.id}\", previous name: \"${request.previousName}\", change name: \"${request.changeName}\"")
                userService.updateUsernameById(request.id, request.previousName)
                logger.warn("Fail to update user name. rollback user-info success.")
            }
        ).joinWithContext(
            contextOrchestrate = TraceIdContextOrchestrator { _, request ->
                userContributionRankService.updateUserRankUsernameIfExists(
                    request.previousName,
                    request.changeName
                )

                request
            },
            contextRollback = TraceIdContextRollback { _, request ->
                logger.warn("Fail to update user name. rollback start user-rank id: \"${request.id}\", previous name: \"${request.previousName}\", change name: \"${request.changeName}\"")
                userContributionRankService.updateUserRankUsernameIfExists(
                    request.changeName,
                    request.previousName
                )
                logger.warn("Fail to update user name. rollback user-rank success.")
            }
        ).joinWithContext(
            contextOrchestrate = TraceIdContextOrchestrator { _, request ->
                guildService.updateUsername(
                    previousName = request.previousName,
                    changeName = request.changeName,
                    // TODO: 배치방식으로 변경 등 조정이 필요하다. 오케스트레이션에 묶으려면 원 트랜잭션으로 끊어야해서 사이즈를 1000000으로 잡는다.
                    // 항상 성공하는 Saga가 필요할까?
                    pageable = PageRequest.of(0, 1_000_000),
                )

                request
            },
            contextRollback = TraceIdContextRollback { _, request ->
                guildService.updateUsername(
                    previousName = request.changeName,
                    changeName = request.previousName,
                    pageable = PageRequest.of(0, 1_000_000),
                )
            }
        ).commitWithContext(
            contextOrchestrate = TraceIdContextOrchestrator { _, request ->
                runCatching {
                    identityApi.updateUserByAuthInfo(
                        entryPoint = request.entryPoint,
                        authenticationId = request.authenticationId,
                        request = UsernameUpdateRequest(changedName = request.changeName),
                    )
                }.getOrElse {
                    if (it is IllegalArgumentException) {
                        return@getOrElse
                    }
                    throw it
                }
            }
        )

    override fun updateUsername(request: UpdateUserOrchestrator.UpdateUserNameRequest) {
        val timeoutMillis = 10.seconds.inWholeMilliseconds
        DistributedLock.withLock(
            key = "UPDATE_USER_NAME:${request.id}",
            leaseMillis = timeoutMillis + 5.seconds.inWholeMilliseconds,
            waitMillis = 0,
        ) {
            val result = orchestrator.sagaSync(
                request = request,
                timeoutMillis = timeoutMillis,
                context = mapOf(
                    TRACE_ID to MDC.get(TRACE_ID),
                ),
            )

            if (result.isSuccess.not()) {
                result.throwError()
            }
        }
    }
}
