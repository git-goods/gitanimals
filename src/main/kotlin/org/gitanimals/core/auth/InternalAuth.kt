package org.gitanimals.core.auth

import jakarta.servlet.http.HttpServletRequest
import org.gitanimals.core.AUTHORIZATION_EXCEPTION
import org.gitanimals.core.AuthorizationException
import org.gitanimals.core.filter.MDCFilter.Companion.USER_ID
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class InternalAuth(
    private val httpServletRequest: HttpServletRequest,
    private val internalAuthClient: InternalAuthClient,
    @Value("\${internal.auth.secret}") private val internalAuthSecret: String,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    private val secretKey by lazy {
        val decodedKey = Base64.getDecoder().decode(internalAuthSecret)
        SecretKeySpec(decodedKey, "AES")
    }

    fun getUserId(throwOnFailure: () -> Unit = throwCannotGetUserId): Long {
        val userId = findUserId()

        if (userId == null) {
            throwOnFailure.invoke()
        }

        return userId ?: throw AUTHORIZATION_EXCEPTION
    }

    fun findUserId(): Long? {
        val userIdInMdc = runCatching {
            MDC.get(USER_ID).toLong()
        }.getOrNull()

        if (userIdInMdc != null) {
            return userIdInMdc
        }

        val token: String? = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION)
        val iv: String? = httpServletRequest.getHeader(INTERNAL_AUTH_IV_KEY)
        val internalAuthSecret: String? = httpServletRequest.getHeader(INTERNAL_AUTH_SECRET_KEY)

        var userId: Long? = runCatching {
            if (internalAuthSecret == null || iv == null) {
                return@runCatching null
            }
            return decrypt(
                iv = Base64.getDecoder().decode(iv),
                secret = Base64.getDecoder().decode(internalAuthSecret),
            )
        }.getOrElse {
            logger.warn("[InternalAuth] Fail to get userId by secret and iv", it)
            null
        }

        if (token != null) {
            userId = runCatching {
                internalAuthClient.getUserByToken(token).id.toLong()
            }.getOrElse {
                if (it is AuthorizationException) {
                    return@getOrElse null
                }
                logger.warn("[InternalAuth] Fail to get userId by token", it)
                null
            }
        }

        return userId
    }

    private fun decrypt(iv: ByteArray, secret: ByteArray): Long {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val spec = GCMParameterSpec(128, iv)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)

        val decryptedBytes = cipher.doFinal(secret)
        return String(decryptedBytes, Charsets.UTF_8).toLong()
    }

    fun encrypt(userId: Long): Encrypted {
        val iv = ByteArray(12)
        SecureRandom().nextBytes(iv)

        val cipher: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val spec = GCMParameterSpec(128, iv)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec)

        val cipherText = cipher.doFinal(userId.toString().toByteArray(Charsets.UTF_8))

        return Encrypted(
            iv = iv,
            secret = cipherText,
        )
    }

    companion object {
        const val INTERNAL_AUTH_IV_KEY = "Internal-Auth-Iv"
        const val INTERNAL_AUTH_SECRET_KEY = "Internal-Auth-Secret"

        private val throwCannotGetUserId: () -> Unit = {
            throw AUTHORIZATION_EXCEPTION
        }
    }
}

class Encrypted(
    val iv: ByteArray,
    val secret: ByteArray,
)
