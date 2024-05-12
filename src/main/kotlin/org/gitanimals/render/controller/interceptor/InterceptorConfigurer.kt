package org.gitanimals.render.controller.interceptor

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfigurer(
    @Value("\${internal.secret}") private val internalSecret: String,
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(internalApiInterceptor())
            .addPathPatterns("/internals/**")
            .excludePathPatterns()
    }

    @Bean
    fun internalApiInterceptor(): InternalApiInterceptor = InternalApiInterceptor(internalSecret)
}
