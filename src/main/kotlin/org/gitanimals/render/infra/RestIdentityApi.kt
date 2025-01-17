package org.gitanimals.render.infra

import org.gitanimals.core.AUTHORIZATION_EXCEPTION
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.render.app.IdentityApi
import org.slf4j.MDC
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
            .header(TRACE_ID, MDC.get(TRACE_ID))
            .exchange { _, response ->
                runCatching {
                    response.bodyTo(IdentityApi.UserResponse::class.java)
                }.getOrElse {
                    throw AUTHORIZATION_EXCEPTION
                }
            }
    }
}
