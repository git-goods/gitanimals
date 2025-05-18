package org.gitanimals.core.extension

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders

object HttpResponseExtension {

    fun HttpServletResponse.cacheControl(maxAgeSeconds: Int): HttpServletResponse {
        this.setHeader(
            HttpHeaders.CACHE_CONTROL,
            "no-cache, no-store, must-revalidate, max-age=$maxAgeSeconds"
        )
        this.setHeader(HttpHeaders.PRAGMA, "no-cache")
        return this
    }
}
