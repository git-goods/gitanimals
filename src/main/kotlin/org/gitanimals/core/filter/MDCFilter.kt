package org.gitanimals.core.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.gitanimals.core.IdGenerator
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import kotlin.system.measureTimeMillis

@Component
class MDCFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val logger = LoggerFactory.getLogger("Request logger")

        runCatching {
            val traceId: String = request.getHeader("traceId") ?: IdGenerator.generate().toString()

            MDC.put(TRACE_ID, traceId)
            MDC.put(PATH, request.requestURI)

            val elapsedTime = measureTimeMillis {
                filterChain.doFilter(request, response)
            }
            MDC.put(ELAPSED_TIME, elapsedTime.toString())
        }.onSuccess {
            if ((MDC.get(PATH) in ignorePath).not()) {
                logger.info("Request Success with status ${response.status}")
            }
        }.also {
            MDC.remove(TRACE_ID)
            MDC.remove(ELAPSED_TIME)
            MDC.remove(PATH)
        }
    }

    companion object {
        const val TRACE_ID = "traceId"
        const val ELAPSED_TIME = "elapsedTime"
        const val PATH = "path"

        private val ignorePath = setOf(
            "/actuator/prometheus",
            "/actuator/health",
        )
    }
}
