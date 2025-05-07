package org.gitanimals.render.app

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange

fun interface GithubRestApi {

    @GetExchange("/users/{username}")
    fun getGithubUser(@PathVariable("username") username: String): GithubUserResponse

    data class GithubUserResponse(
        @JsonProperty("login")
        val name: String,
        val id: String,
    )
}
