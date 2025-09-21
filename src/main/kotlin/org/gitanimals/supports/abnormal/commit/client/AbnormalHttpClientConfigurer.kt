package org.gitanimals.supports.abnormal.commit.client

import org.gitanimals.core.HttpClientErrorHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
@Profile("!test")
class AbnormalHttpClientConfigurer(
    @Value("\${github.token}") private val token: String,
) {

    @Bean
    fun renderGithubRestApiHttpClient(): AbnormalGithubRestApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(abnormalHttpClientErrorHandler())
            .requestInterceptor { request, body, execution ->
                request.headers.add(HttpHeaders.AUTHORIZATION, token)
                execution.execute(request, body)
            }
            .baseUrl("https://api.github.com")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(AbnormalGithubRestApi::class.java)
    }


    @Bean
    fun abnormalHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}

@Configuration
@Profile("test")
class AbnormalTestHttpClientConfigurer(
    @Value("\${github.token}") private val token: String,
) {

    @Bean
    fun renderGithubRestApiHttpClient(): AbnormalGithubRestApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(abnormalHttpClientErrorHandler())
            .requestInterceptor { request, body, execution ->
                execution.execute(request, body)
            }
            .baseUrl("https://api.github.com")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(AbnormalGithubRestApi::class.java)
    }


    @Bean
    fun abnormalHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}

