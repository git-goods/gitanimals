package org.gitanimals.guild.domain.event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

object DomainEventPublisher {

    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    fun <T : Any> publish(event: T) {
        applicationEventPublisher.publishEvent(event)
    }

    @Component("guild.eventPublisherInjector")
    class EventPublisherInjector(applicationEventPublisher: ApplicationEventPublisher) {

        init {
            DomainEventPublisher.applicationEventPublisher = applicationEventPublisher
        }
    }
}
