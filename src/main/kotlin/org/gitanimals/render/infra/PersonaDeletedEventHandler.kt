package org.gitanimals.render.infra

import org.gitanimals.render.domain.event.PersonaDeleted
import org.gitanimals.render.infra.CustomExecutorConfigurer.Companion.GRACEFUL_SHUTDOWN_EXECUTOR
import org.rooftop.netx.api.SagaManager
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class PersonaDeletedEventHandler(
    private val sagaManager: SagaManager,
) {

    @Async(GRACEFUL_SHUTDOWN_EXECUTOR)
    @EventListener
    fun handlePersonaDeletedEvent(personaDeleted: PersonaDeleted) {
        sagaManager.startSync(personaDeleted)
    }
}
