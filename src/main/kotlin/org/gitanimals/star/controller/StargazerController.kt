package org.gitanimals.star.controller

import org.gitanimals.star.domain.StargazerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StargazerController(
    private val stargazerService: StargazerService,
) {

    @GetMapping("/stargazers/{login}/press")
    fun isPressStar(@PathVariable("login") login: String): Map<String, Boolean> {
        val isPressStar = stargazerService.existsByLogin(login)

        return mapOf("isPressStar" to isPressStar)
    }
}
