package org.gitanimals.guild.saga

import org.gitanimals.guild.app.RenderApi
import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.saga.event.PersonaDeleted
import org.rooftop.netx.api.SagaStartEvent
import org.rooftop.netx.api.SagaStartListener
import org.rooftop.netx.api.SuccessWith
import org.rooftop.netx.meta.SagaHandler

@SagaHandler
class PersonaDeletedSagaHandler(
    private val guildService: GuildService,
    private val renderApi: RenderApi,
) {

    @SagaStartListener(
        event = PersonaDeleted::class,
        noRollbackFor = [IllegalStateException::class],
        successWith = SuccessWith.END,
    )
    fun handlePersonaDeletedEvent(sagaStartEvent: SagaStartEvent) {
        val personaDeleted = sagaStartEvent.decodeEvent(PersonaDeleted::class)

        val changePersona =
            renderApi.getUserByName(personaDeleted.username).personas.maxByOrNull { it.level }
                ?: throw IllegalStateException("Cannot find any persona by username \"${personaDeleted.username}\"")

        guildService.deletePersonaSync(
            userId = personaDeleted.userId,
            deletedPersonaId = personaDeleted.personaId,
            changePersonaId = changePersona.id.toLong(),
            changePersonaType = changePersona.type,
        )
    }
}
