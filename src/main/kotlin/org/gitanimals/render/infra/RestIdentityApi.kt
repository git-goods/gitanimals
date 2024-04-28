package org.gitanimals.render.infra

import org.gitanimals.render.app.IdentityApi
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class RestIdentityApi : IdentityApi {

    private val restClient = RestClient.create("https://api.gitanimals.org")

    override fun getUserByToken(token: String): IdentityApi.UserResponse {
        return restClient.get()
            .uri("/users")
            .header(HttpHeaders.AUTHORIZATION, token)
            .exchange { _, response ->
                runCatching {
                    response.bodyTo(IdentityApi.UserResponse::class.java)
                }.getOrElse {
                    throw IllegalArgumentException("Unauthorized user")
                }
            }
    }
}
