package org.gitanimals.render.controller

import org.gitanimals.render.app.AnimationFacade
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
    fun getSvgAnimation(@PathVariable("username") username: String): String {
        return animationFacade.getSvgAnimationByUsername(username)
    }
}
