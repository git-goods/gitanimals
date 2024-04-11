package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.render.app.AnimationFacade
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/farms")
class AnimationController(
    private val animationFacade: AnimationFacade,
) {

    @GetMapping(value = ["/{username}"], produces = ["image/svg+xml"])
    fun getSvgAnimation(@PathVariable("username") username: String, response: HttpServletResponse): String {
        response.setHeader(HttpHeaders.CACHE_CONTROL, "max-age=1")
        return animationFacade.getSvgAnimationByUsername(username)
    }
}
