package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.core.Mode
import org.gitanimals.core.PersonaType
import org.gitanimals.core.extension.HttpResponseExtension.cacheControl
import org.gitanimals.core.extension.StringExtension.deleteBrackets
import org.gitanimals.core.extension.StringExtension.trimNotDigitCharacters
import org.gitanimals.render.app.AnimationFacade
import org.gitanimals.render.app.AssetsFacade
import org.gitanimals.render.app.response.AssetsResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*

@RestController
class AnimationController(
    private val animationFacade: AnimationFacade,
    private val assetsFacade: AssetsFacade,
) {

    @GetMapping(value = ["/farms/{username}"], produces = ["image/svg+xml"])
    fun getFarmSvgAnimation(
        @PathVariable("username") username: String,
        response: HttpServletResponse
    ): String {
        response.cacheControl(3600)
        return animationFacade.getFarmAnimation(username.deleteBrackets())
    }

    @GetMapping(value = ["/lines/{username}"], produces = ["image/svg+xml"])
    fun getLineSvgAnimation(
        @PathVariable("username") username: String,
        @RequestParam(name = "pet-id", defaultValue = "0") personaId: String,
        @RequestParam(name = "contribution-view", defaultValue = "true") contributionView: Boolean,
        response: HttpServletResponse,
    ): String {
        response.cacheControl(3600)

        val mode = when (contributionView) {
            true -> Mode.LINE
            false -> Mode.LINE_NO_CONTRIBUTION
        }

        return animationFacade.getLineAnimation(
            username = username.deleteBrackets(),
            personaId = personaId.trimNotDigitCharacters().toLong(),
            mode = mode,
        )
    }

    @GetMapping(value = ["/assets"])
    fun downloadAssetsByPersonaType(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("personaType") personaType: PersonaType,
    ): AssetsResponse {
        return assetsFacade.findAllAssets(token, personaType)
    }

    @GetMapping(value = ["/assets/images"], produces = ["image/svg+xml"])
    fun getAssetImage(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam("personaType") personaType: PersonaType,
        @RequestParam("emotion") emotion: String,
    ): String {
        return assetsFacade.findAssetSvg(token, personaType, emotion)
    }
}
