package org.gitanimals.core.auth

import org.gitanimals.core.AuthorizationException
import org.gitanimals.core.filter.MDCFilter
import org.slf4j.MDC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.invoker.HttpServiceProxyFactory

fun interface InternalAuthClient {

    @GetExchange("/users")
    fun getUserByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) token: String): UserResponse

    data class UserResponse(
        val id: String,
        val entryPoint: String,
    )
}

@Configuration
class InternalAuthClientConfigurer {

    @Bean
    fun internalAuthHttpClient(): InternalAuthClient {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(MDCFilter.TRACE_ID, MDC.get(MDCFilter.TRACE_ID))
                execution.execute(request, body)
            }
            .defaultStatusHandler(HttpClientErrorHandler())
            .baseUrl("https://api.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(InternalAuthClient::class.java)
    }

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
}
