package org.gitanimals.render.controller

import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.core.Mode
import org.gitanimals.core.extension.HttpResponseExtension.cacheControl
import org.gitanimals.core.extension.StringExtension.deleteBrackets
import org.gitanimals.core.extension.StringExtension.trimNotDigitCharacters
import org.gitanimals.render.app.AnimationFacade
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class InternalAnimationController(
    private val animationFacade: AnimationFacade,
    @Value("\${internal.image.secret}") private val internalImageSecret: String,
) {

    @GetMapping(value = ["/lines/{username}/only-pets"], produces = ["image/svg+xml"])
    fun getOnlyPetAnimation(
        @PathVariable("username") username: String,
        @RequestParam(name = "pet-id", defaultValue = "0") personaId: String,
        @RequestHeader("Image-Secret") renderSecret: String,
        response: HttpServletResponse,
    ): String {
        require(renderSecret == this.internalImageSecret)
        response.cacheControl(3600)

        return animationFacade.getLineAnimation(
            username = username.deleteBrackets(),
            personaId = personaId.trimNotDigitCharacters().toLong(),
            mode = Mode.NONE,
        )
    }
}
