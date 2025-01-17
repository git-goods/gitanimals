package org.gitanimals.core.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.core.IdGenerator
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class MDCFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        runCatching {
            val traceId: String = request.getHeader("traceId") ?: IdGenerator.generate().toString()

            MDC.put(TRACE_ID, traceId)
            filterChain.doFilter(request, response)
        }.also {
            MDC.remove(TRACE_ID)
        }
    }

    companion object {
        const val TRACE_ID = "traceId"
    }
}
