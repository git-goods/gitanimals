package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.render.app.AnimationFacade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/farms")
class AnimationController(
    private val animationFacade: AnimationFacade,
) {

    @GetMapping(value = ["/{username}"], produces = ["image/svg+xml"])
    fun getSvgAnimation(
        @PathVariable("username") username: String,
        @RequestParam(name = "mode", defaultValue = "FARM") mode: String,
        response: HttpServletResponse
    ): String {
        response.noCache()
        return animationFacade.getSvgAnimation(username, mode)
    }

    fun HttpServletResponse.noCache(): HttpServletResponse {
        this.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        return this
    }
}
