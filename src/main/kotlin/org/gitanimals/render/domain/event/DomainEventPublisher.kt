package org.gitanimals.render.domain.event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

object DomainEventPublisher {

    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    fun <T : Any> publish(event: T) {
        applicationEventPublisher.publishEvent(event)
    }

    @Component("render.eventPublisherInjector")
    class EventPublisherInjector(applicationEventPublisher: ApplicationEventPublisher) {

        init {
            DomainEventPublisher.applicationEventPublisher = applicationEventPublisher
        }
    }
}
