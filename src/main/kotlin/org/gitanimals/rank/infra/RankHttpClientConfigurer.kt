package org.gitanimals.rank.infra

import org.gitanimals.core.auth.InternalAuthRequestInterceptor
import org.gitanimals.core.filter.MDCFilter.Companion.TRACE_ID
import org.gitanimals.rank.app.GuildApi
import org.gitanimals.rank.app.IdentityApi
import org.gitanimals.rank.app.RenderApi
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
@Profile("!test")
class RankHttpClientConfigurer(
    @Value("\${internal.secret}") private val internalSecret: String,
    private val internalAuthRequestInterceptor: InternalAuthRequestInterceptor,
) {

    @Bean
    fun rankIdentityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(TRACE_ID, MDC.get(TRACE_ID))
                if (request.uri.path.startsWith("/internals")) {
                    request.headers.add(INTERNAL_SECRET_KEY, internalSecret)
                }
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("https://api.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun rankRenderApiHttpClient(): RenderApi {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(TRACE_ID, MDC.get(TRACE_ID))
                if (request.uri.path.startsWith("/internals")) {
                    request.headers.add(INTERNAL_SECRET_KEY, internalSecret)
                }
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("https://render.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }

    @Bean
    fun rankGuildApiHttpClient(): GuildApi {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(TRACE_ID, MDC.get(TRACE_ID))
                if (request.uri.path.startsWith("/internals")) {
                    request.headers.add(INTERNAL_SECRET_KEY, internalSecret)
                }
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("https://render.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(GuildApi::class.java)
    }

    @Bean
    fun rankHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()

    private companion object {
        private const val INTERNAL_SECRET_KEY = "Internal-Secret"
    }
}

@Configuration
@Profile("test")
class RankTestHttpClientConfigurer {

    @Bean
    fun rankIdentityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun rankRenderApiHttpClient(): RenderApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }

    @Bean
    fun rankGuildApiHttpClient(): GuildApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(rankHttpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(GuildApi::class.java)
    }

    @Bean
    fun rankHttpClientErrorHandler(): HttpClientErrorHandler = HttpClientErrorHandler()
}
