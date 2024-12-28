package org.gitanimals.guild.infra

import org.gitanimals.guild.app.IdentityApi
import org.gitanimals.guild.app.RenderApi
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
        val restClient = RestClient.create("https://api.gitanimals.org")

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun renderApiHttpClient(): RenderApi {
        val restClient = RestClient.create("https://render.gitanimals.org")

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }
}

@Configuration
@Profile("test")
class TestHttpClientConfigurer {

    @Bean
    fun identityApiHttpClient(): IdentityApi {
        val restClient = RestClient.create("http://localhost:8080")

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(IdentityApi::class.java)
    }

    @Bean
    fun renderApiHttpClient(): RenderApi {
        val restClient = RestClient.create("http://localhost:8080")

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClient))
            .build()

        return httpServiceProxyFactory.createClient(RenderApi::class.java)
    }
}
