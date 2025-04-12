package org.gitanimals.core.auth

import org.gitanimals.core.filter.MDCFilter.Companion.USER_ID
import org.slf4j.MDC
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class InternalAuthRequestInterceptor(
    private val internalAuth: InternalAuth,
) : ClientHttpRequestInterceptor {

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        val userId = runCatching {
            MDC.get(USER_ID).toLong()
        }.getOrNull()

        if (userId != null) {
            val encrypt = internalAuth.encrypt(userId = userId)

            request.headers.add(
                InternalAuth.INTERNAL_AUTH_SECRET_KEY,
                Base64.getEncoder().encodeToString(encrypt.secret),
            )
            request.headers.add(
                InternalAuth.INTERNAL_AUTH_IV_KEY,
                Base64.getEncoder().encodeToString(encrypt.iv),
            )
        }

        return execution.execute(request, body)
    }
}
