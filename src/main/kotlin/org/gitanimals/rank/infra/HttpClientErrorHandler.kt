package org.gitanimals.rank.infra

import org.gitanimals.core.AuthorizationException
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.ResponseErrorHandler


class HttpClientErrorHandler : ResponseErrorHandler {

    override fun hasError(response: ClientHttpResponse): Boolean {
        return response.statusCode.isError
    }

    override fun handleError(response: ClientHttpResponse) {
        val body = response.body.bufferedReader().use { it.readText() }
        when {
            response.statusCode.isSameCodeAs(HttpStatus.UNAUTHORIZED) ->
                throw AuthorizationException(body)

            response.statusCode.is4xxClientError ->
                throw IllegalArgumentException(body)

            response.statusCode.is5xxServerError ->
                throw IllegalStateException(body)
        }
    }
}
