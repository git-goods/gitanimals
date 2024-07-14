package org.gitanimals.render.controller

import org.gitanimals.render.controller.response.TotalPersonaResponse
import org.gitanimals.render.controller.response.TotalUserResponse
import org.gitanimals.render.domain.PersonaStatisticService
import org.gitanimals.render.domain.UserStatisticService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatisticController(
    private val userStatisticService: UserStatisticService,
    private val personaStatisticService: PersonaStatisticService,
) {

    @GetMapping("/users/statistics/total")
    fun totalUsers(): TotalUserResponse =
        TotalUserResponse.from(userStatisticService.getTotalUserCount())

    @GetMapping("/personas/statistics/total")
    fun totalAdaptedPersonas(): TotalPersonaResponse =
        TotalPersonaResponse.from(personaStatisticService.getTotalPersonaCount())
}
