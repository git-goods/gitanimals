package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.render.app.AnimationFacade
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AnimationController(
    private val animationFacade: AnimationFacade,
) {

    @GetMapping(value = ["/farms/{username}"], produces = ["image/svg+xml"])
    fun getFarmSvgAnimation(
        @PathVariable("username") username: String,
        response: HttpServletResponse
    ): String {
        response.cacheControl(3600)
        return animationFacade.getFarmAnimation(username)
    }

    @GetMapping(value = ["/lines/{username}"], produces = ["image/svg+xml"])
    fun getLineSvgAnimation(
        @PathVariable("username") username: String,
        @RequestParam(name = "pet-id", defaultValue = "0") personaId: Long,
        response: HttpServletResponse,
    ): String {
        response.cacheControl(3600)
        return animationFacade.getLineAnimation(username, personaId)
    }

    fun HttpServletResponse.cacheControl(maxAgeSeconds: Int): HttpServletResponse {
        this.setHeader(
            HttpHeaders.CACHE_CONTROL,
            "no-cache, no-store, must-revalidate, max-age=$maxAgeSeconds"
        )
        this.setHeader(HttpHeaders.PRAGMA, "no-cache")
        return this
    }
}
