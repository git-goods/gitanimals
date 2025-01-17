package org.gitanimals.core.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class CorsFilter : Filter {

    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain
    ) {
        (response as HttpServletResponse).allowCors()
        chain.doFilter(request, response)
    }

    private fun HttpServletResponse.allowCors(): ServletResponse {
        this.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
        this.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*")
        this.addHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600")
        this.addHeader(
            HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
            "Origin, X-Requested-With, Content-Type, Accept, Authorization, Api-Version"
        )
        return this
    }
}
