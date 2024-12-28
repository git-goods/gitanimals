package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.render.app.AnimationFacade
import org.gitanimals.core.Mode
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
        return animationFacade.getFarmAnimation(deleteBrackets(username))
    }

    @GetMapping(value = ["/lines/{username}"], produces = ["image/svg+xml"])
    fun getLineSvgAnimation(
        @PathVariable("username") username: String,
        @RequestParam(name = "pet-id", defaultValue = "0") personaId: Long,
        @RequestParam(name = "contribution-view", defaultValue = "true") contributionView: Boolean,
        response: HttpServletResponse,
    ): String {
        response.cacheControl(3600)

        val mode = when (contributionView) {
            true -> Mode.LINE
            false -> Mode.LINE_NO_CONTRIBUTION
        }

        return animationFacade.getLineAnimation(deleteBrackets(username), personaId, mode)
    }

    private fun deleteBrackets(username: String): String {
        val start = when (username[0]) {
            '{' -> 1
            else -> 0
        }

        val end = when (username.last()) {
            '}' -> username.length - 1
            else -> username.length
        }

        return username.substring(start, end)
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
