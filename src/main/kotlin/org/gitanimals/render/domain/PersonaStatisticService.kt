package org.gitanimals.render.domain

import org.gitanimals.core.PersonaType
import org.gitanimals.render.domain.response.NewPetDropRateDistribution
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PersonaStatisticService(
    private val personaStatisticRepository: PersonaStatisticRepository,
) {

    @Cacheable(value = ["total_persona_count_cache"])
    fun getTotalPersonaCount() = personaStatisticRepository.count()

    fun getAggregatedPersonaDistributionByCreatedAtAfter(createdAt: Instant): List<NewPetDropRateDistribution> {
        var pageable = PageRequest.of(0, 100)
        var personas = personaStatisticRepository.findAllPersonaByCreatedAtAfter(createdAt, pageable)

        val newPetDropRateDistributionMap: MutableMap<Double, Int> =
            PersonaType.entries.associateTo(mutableMapOf()) {
                it.weight to 0
            }

        personas.content.forEach {
            newPetDropRateDistributionMap.getOrPut(it.type.weight) { 0 }
            newPetDropRateDistributionMap[it.type.weight] = (newPetDropRateDistributionMap[it.type.weight] ?: 0) + 1
        }

        while (personas.hasNext()) {
            pageable = pageable.next()
            personas = personaStatisticRepository.findAllPersonaByCreatedAtAfter(createdAt, pageable)
            personas.content.forEach {
                newPetDropRateDistributionMap.getOrPut(it.type.weight) { 0 }
                newPetDropRateDistributionMap[it.type.weight] = (newPetDropRateDistributionMap[it.type.weight] ?: 0) + 1
            }
        }

        return newPetDropRateDistributionMap.map {
            val dropRate = it.key
            val count = it.value

            NewPetDropRateDistribution(dropRate, count)
        }
    }
}
