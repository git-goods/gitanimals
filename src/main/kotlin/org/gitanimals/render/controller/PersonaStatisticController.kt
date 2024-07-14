package org.gitanimals.render.controller

import org.gitanimals.render.controller.response.TotalPersonaResponse
import org.gitanimals.render.domain.PersonaStatisticService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonaStatisticController(
    private val personaStatisticService: PersonaStatisticService,
) {

    @GetMapping("/personas/statistics/total")
    fun totalAdaptedPersonas(): TotalPersonaResponse =
        TotalPersonaResponse.from(personaStatisticService.getTotalPersonaCount())
}
