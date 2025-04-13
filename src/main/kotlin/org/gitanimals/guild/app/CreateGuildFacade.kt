package org.gitanimals.guild.app

import org.gitanimals.core.TraceIdContextOrchestrator
import org.gitanimals.core.TraceIdContextRollback
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.core.filter.MDCFilter.Companion.USER_ID
import org.gitanimals.guild.app.request.CreateGuildRequest
import org.gitanimals.guild.app.response.GuildResponse
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.RandomGuildCache
import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.rooftop.netx.api.Orchestrator
import org.rooftop.netx.api.OrchestratorFactory
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*
import kotlin.time.Duration.Companion.minutes

@Service
class CreateGuildFacade(
    private val guildService: GuildService,
    private val identityApi: IdentityApi,
    private val renderApi: RenderApi,
    private val randomGuildCache: RandomGuildCache,
    @Value("\${internal.secret}") internalSecret: String,
    orchestratorFactory: OrchestratorFactory,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)
    private lateinit var createGuildOrchestrator: Orchestrator<CreateGuildRequest, GuildResponse>

    fun createGuild(
        token: String,
        createGuildRequest: CreateGuildRequest,
    ): GuildResponse {
        createGuildRequest.requireValidTitle()

        return createGuildOrchestrator.sagaSync(
            request = createGuildRequest,
            context = mapOf(
                "token" to token,
                IDEMPOTENCY_KEY to UUID.randomUUID().toString(),
                TRACE_ID to MDC.get(TRACE_ID),
                USER_ID to MDC.get(USER_ID),
            ),
            timeoutMillis = 1.minutes.inWholeMilliseconds,
        ).decodeResultOrThrow(GuildResponse::class).also {
            randomGuildCache.updateForce()
        }
    }

    init {
        createGuildOrchestrator =
            orchestratorFactory.create<CreateGuildRequest>("Create guild orchestrator")
                .startWithContext(
                    contextOrchestrate = TraceIdContextOrchestrator { context, createGuildRequest ->
                        val token = context.decodeContext("token", String::class)
                        val idempotencyKey = context.decodeContext(IDEMPOTENCY_KEY, String::class)

                        val leader = identityApi.getUserByToken(token)
                        require(leader.points.toInt() >= CREATE_GUILD_COST) {
                            "Cannot create guild cause not enough points. points: \"${leader.points}\""
                        }

                        identityApi.decreasePoint(
                            token = token,
                            internalSecret = internalSecret,
                            idempotencyKey = idempotencyKey,
                            point = CREATE_GUILD_COST.toString(),
                        )
                        createGuildRequest
                    },
                    contextRollback = TraceIdContextRollback { context, _ ->
                        val token = context.decodeContext("token", String::class)
                        val idempotencyKey = context.decodeContext(IDEMPOTENCY_KEY, String::class)

                        logger.warn("Fail to create guild increase point...")
                        identityApi.increasePoint(
                            token = token,
                            internalSecret = internalSecret,
                            idempotencyKey = idempotencyKey,
                            point = CREATE_GUILD_COST.toString(),
                        )
                        logger.warn("Fail to create guild increase point success")
                    }
                )
                .commitWithContext(
                    contextOrchestrate = TraceIdContextOrchestrator { context, createGuildRequest ->
                        val token = context.decodeContext("token", String::class)

                        val leader = identityApi.getUserByToken(token)
                        val renderUser =
                            renderApi.getUserByName(leader.username)


                        val createLeaderRequest = CreateLeaderRequest(
                            userId = leader.id.toLong(),
                            name = leader.username,
                            personaId = renderUser.personas.firstOrNull { it.id == createGuildRequest.personaId }?.id?.toLong()
                                ?: throw IllegalArgumentException("Cannot find persona by id \"${createGuildRequest.personaId}\""),
                            contributions = renderUser.totalContributions.toLong(),
                            personaType = renderUser.personas.find { it.id == createGuildRequest.personaId }!!.type,
                        )

                        val guild = guildService.createGuild(
                            title = createGuildRequest.title,
                            body = createGuildRequest.body,
                            guildIcon = createGuildRequest.guildIcon,
                            farmType = createGuildRequest.farmType,
                            autoJoin = createGuildRequest.autoJoin,
                            createLeaderRequest = createLeaderRequest,
                        )

                        GuildResponse.from(guild)
                    }
                )
    }

    private companion object {
        private const val IDEMPOTENCY_KEY = "IDEMPOTENCY_KEY"
        private const val CREATE_GUILD_COST = 3_000
    }
}
