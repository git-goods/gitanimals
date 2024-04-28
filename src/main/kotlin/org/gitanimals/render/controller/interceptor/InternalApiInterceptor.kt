package org.gitanimals.render.controller.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class InternalApiInterceptor(
    private val whiteIps: List<String>,
) : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
    ): Boolean {
        val ip = extractIp(request)
        return whiteIps.contains(ip)
    }

    private fun extractIp(request: HttpServletRequest): String {
        val headers = arrayOf(
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR",
            "X-Real-IP", "X-RealIP", "REMOTE_ADDR"
        )

        var ip: String = request.getHeader("X-Forwarded-For")

        for (header in headers) {
            if (ip.isEmpty() || "unknown".equals(ip, ignoreCase = true)) {
                ip = request.getHeader(header)
            }
        }

        if (ip.isEmpty() || "unknown".equals(ip, ignoreCase = true)) {
            ip = request.remoteAddr
        }

        if (ip == "0:0:0:0:0:0:0:1") {
            ip = "127.0.0.1"
        }

        return ip
    }
}
