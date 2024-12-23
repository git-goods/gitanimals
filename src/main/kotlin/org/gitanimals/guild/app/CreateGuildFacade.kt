package org.gitanimals.guild.app

import org.gitanimals.guild.app.request.CreateGuildRequest
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.domain.request.CreateLeaderRequest
import org.rooftop.netx.api.Orchestrator
import org.rooftop.netx.api.OrchestratorFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateGuildFacade(
    private val guildService: GuildService,
    private val identityApi: IdentityApi,
    private val renderApi: RenderApi,
    @Value("\${internal.secret}") internalSecret: String,
    orchestratorFactory: OrchestratorFactory,
) {

    private lateinit var createGuildOrchestrator: Orchestrator<CreateGuildRequest, Unit>

    fun createGuild(
        token: String,
        createGuildRequest: CreateGuildRequest,
    ) {
        createGuildOrchestrator.sagaSync(
            createGuildRequest,
            context = mapOf("token" to token, IDEMPOTENCY_KEY to UUID.randomUUID().toString()),
        ).decodeResultOrThrow(Unit::class)
    }

    init {
        createGuildOrchestrator =
            orchestratorFactory.create<CreateGuildRequest>("Create guild orchestrator")
                .startWithContext(
                    contextOrchestrate = { context, createGuildRequest ->
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
                    contextRollback = { context, _ ->
                        val token = context.decodeContext("token", String::class)
                        val idempotencyKey = context.decodeContext(IDEMPOTENCY_KEY, String::class)

                        identityApi.increasePoint(
                            token = token,
                            internalSecret = internalSecret,
                            idempotencyKey = idempotencyKey,
                            point = CREATE_GUILD_COST.toString(),
                        )
                    }
                )
                .commitWithContext(
                    contextOrchestrate = { context, createGuildRequest ->
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

                        guildService.createGuild(
                            title = createGuildRequest.title,
                            body = createGuildRequest.body,
                            guildIcon = createGuildRequest.guildIcon,
                            farmType = createGuildRequest.farmType,
                            autoJoin = createGuildRequest.autoJoin,
                            createLeaderRequest = createLeaderRequest,
                        )
                    }
                )
    }

    private companion object {
        private const val IDEMPOTENCY_KEY = "IDEMPOTENCY_KEY"
        private const val CREATE_GUILD_COST = 30_000
    }
}
