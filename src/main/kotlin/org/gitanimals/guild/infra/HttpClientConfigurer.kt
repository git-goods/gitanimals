package org.gitanimals.guild.infra

import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.guild.app.IdentityApi
import org.gitanimals.guild.app.RenderApi
import org.slf4j.MDC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
@Profile("!test")
class HttpClientConfigurer {

    @Bean
    fun identityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .defaultHeaders {
                it.add(TRACE_ID, MDC.get(TRACE_ID))
            }
            .defaultStatusHandler(httpClientErrorHandler())
            .baseUrl("https://api.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun renderApiHttpClient(): RenderApi {
        val restClient = RestClient
            .builder()
            .defaultHeaders {
                it.add(TRACE_ID, MDC.get(TRACE_ID))
            }
            .defaultStatusHandler(httpClientErrorHandler())
            .baseUrl("https://render.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }

    @Bean
    fun httpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}

@Configuration
@Profile("test")
class TestHttpClientConfigurer {

    @Bean
    fun identityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(httpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun renderApiHttpClient(): RenderApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(httpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }


    @Bean
    fun httpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}
