package org.gitanimals.core

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

object DomainEventPublisher {

    private lateinit var applicationEventPublisher: ApplicationEventPublisher
    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    fun <T : Any> publish(event: T) {
        runCatching {
            applicationEventPublisher.publishEvent(event)
        }.onSuccess {
            logger.info("Publish event success. event: \"$event\"")
        }.onFailure {
            logger.error("Publish event fail. event: \"$event\"")
        }
    }

    @Component
    class EventPublisherInjector(applicationEventPublisher: ApplicationEventPublisher) {

        init {
            DomainEventPublisher.applicationEventPublisher = applicationEventPublisher
        }
    }
}
