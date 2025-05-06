package org.gitanimals.render.controller

import org.gitanimals.render.controller.response.TotalUserResponse
import org.gitanimals.render.domain.UserStatisticService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserStatisticController(
    private val userStatisticService: UserStatisticService,
) {

    @GetMapping("/users/statistics/total")
    fun totalUsers(): TotalUserResponse =
        TotalUserResponse.from(userStatisticService.getTotalUserCount())
}
