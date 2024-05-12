package org.gitanimals.render.controller.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class InternalApiInterceptor(
    private val internalSecret: String,
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        val requestSecret = request.getHeader("Internal-Secret")

        if (requestSecret == internalSecret) {
            return true
        }

        response.sendError(403, "Cannot call internal API")
        return false
    }
}
