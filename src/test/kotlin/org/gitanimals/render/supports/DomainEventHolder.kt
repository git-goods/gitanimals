package org.gitanimals.render.supports

import io.kotest.matchers.shouldBe
import org.gitanimals.render.domain.event.PersonaDeleted
import org.springframework.boot.test.context.TestComponent
import org.springframework.context.event.EventListener
import kotlin.reflect.KClass

@TestComponent
class DomainEventHolder {

    private val events = mutableMapOf<KClass<*>, Int>()

    @EventListener(PersonaDeleted::class)
    fun handlePersonaDeleted(personaDeleted: PersonaDeleted) {
        events[personaDeleted::class] = events.getOrDefault(personaDeleted::class, 0) + 1
    }

    fun eventsShouldBe(kClass: KClass<*>, count: Int) {
        events[kClass] shouldBe count
    }

    fun deleteAll() = events.clear()
}
