package org.gitanimals.guild.infra

import org.gitanimals.core.auth.InternalAuthRequestInterceptor
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
class GuildHttpClientConfigurer(
    private val internalAuthRequestInterceptor: InternalAuthRequestInterceptor,
) {

    @Bean
    fun identityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(TRACE_ID, MDC.get(TRACE_ID))
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(guildHttpClientErrorHandler())
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
            .requestInterceptor { request, body, execution ->
                request.headers.add(TRACE_ID, MDC.get(TRACE_ID))
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(guildHttpClientErrorHandler())
            .baseUrl("https://render.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }

    @Bean
    fun guildHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}

@Configuration
@Profile("test")
class GuildTestHttpClientConfigurer {

    @Bean
    fun identityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(guildHttpClientErrorHandler())
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
            .defaultStatusHandler(guildHttpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }


    @Bean
    fun guildHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}
