package org.gitanimals.render.domain

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class PersonaStatisticService(
    private val personaStatisticRepository: PersonaStatisticRepository,
) {

    @Cacheable(value = ["total_persona_count_cache"])
    fun getTotalPersonaCount() = personaStatisticRepository.count()
}
