package org.gitanimals.supports.orchestrate

import org.gitanimals.core.HttpClientErrorHandler
import org.gitanimals.core.auth.InternalAuthRequestInterceptor
import org.gitanimals.core.filter.MDCFilter
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
class SupportsOrchestrateHttpClientConfigurer(
    @Value("\${internal.secret}") private val internalSecret: String,
    private val internalAuthRequestInterceptor: InternalAuthRequestInterceptor,
) {

    @Bean
    fun supportsOrchestrateIdentityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .requestInterceptor { request, body, execution ->
                request.headers.add(MDCFilter.TRACE_ID, MDC.get(MDCFilter.TRACE_ID))
                if (request.uri.path.startsWith("/internals")) {
                    request.headers.add(INTERNAL_SECRET_KEY, internalSecret)
                }
                execution.execute(request, body)
            }
            .requestInterceptor(internalAuthRequestInterceptor)
            .defaultStatusHandler(supportsOrchestrateHttpClientErrorHandler())
            .baseUrl("https://api.gitanimals.org")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun supportsOrchestrateHttpClientErrorHandler(): HttpClientErrorHandler =
        HttpClientErrorHandler()

    private companion object {
        private const val INTERNAL_SECRET_KEY = "Internal-Secret"
    }
}

@Configuration
@Profile("test")
class SupportsOrchestrateTestHttpClientConfigurer {

    @Bean
    fun supportsOrchestrateIdentityApiHttpClient(): IdentityApi {
        val restClient = RestClient
            .builder()
            .defaultStatusHandler(supportsOrchestrateHttpClientErrorHandler())
            .baseUrl("http://localhost:8080")
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun supportsOrchestrateHttpClientErrorHandler(): HttpClientErrorHandler =
        HttpClientErrorHandler()
}
