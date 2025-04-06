package org.gitanimals.supports.deadletter

import org.rooftop.netx.spi.DeadLetterRegistry
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeadLetterListenConfigurer(
    private val deadLetterRegistry: DeadLetterRegistry,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Bean
    fun deadLetterEventPublisher(): DeadLetterEventPublisher {
        return DeadLetterEventPublisher(applicationEventPublisher).apply {
            deadLetterRegistry.addListener(this)
        }
    }
}
