package org.gitanimals.render.controller

import org.gitanimals.core.auth.RequiredUserEntryPoints
import org.gitanimals.core.auth.UserEntryPoint
import org.gitanimals.render.app.PersonaEvolutionFacade
import org.gitanimals.render.controller.response.PersonaEvolutionableResponse
import org.gitanimals.render.controller.response.PersonaResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class PersonaEvolutionController(
    private val personaEvolutionFacade: PersonaEvolutionFacade,
) {

    @PostMapping("/personas/{personaId}/evolution")
    @ResponseStatus(HttpStatus.OK)
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun evolutionPersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable personaId: Long,
    ): PersonaResponse {
        return PersonaResponse.from(
            personaEvolutionFacade.evolutionPersona(
                token = token,
                personaId = personaId,
            )
        )
    }

    @GetMapping("/personas/{personaId}/evolution")
    @ResponseStatus(HttpStatus.OK)
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun isEvolutionablePersona(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @PathVariable personaId: Long,
    ): PersonaEvolutionableResponse {
        return PersonaEvolutionableResponse(
            evolutionAble = personaEvolutionFacade.isEvoluationable(
                token = token,
                personaId = personaId,
            )
        )
    }
}
