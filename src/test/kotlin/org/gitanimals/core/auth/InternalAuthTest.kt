package org.gitanimals.core.auth

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.mockk.every
import jakarta.servlet.http.HttpServletRequest
import org.gitanimals.core.auth.InternalAuth.Companion.INTERNAL_AUTH_IV_KEY
import org.gitanimals.core.auth.InternalAuth.Companion.INTERNAL_AUTH_SECRET_KEY
import org.gitanimals.core.auth.InternalAuthClient.UserResponse
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import java.util.*

@ContextConfiguration(
    classes = [
        InternalAuth::class,
    ]
)
@TestPropertySource("classpath:application.properties")
@DisplayName("InternalAuth 클래스의")
internal class InternalAuthTest(
    @MockkBean(relaxed = true) private val internalAuthClient: InternalAuthClient,
    @MockkBean(relaxed = true) private val httpServletRequest: HttpServletRequest,
    private val internalAuth: InternalAuth,
) : DescribeSpec({

    describe("encrypt 메소드는") {
        context("userId 를 입력받으면") {
            val userId = 123456789L

            it("암호화된 string과 사용된 iv값을 응답한다") {
                val encrypted = internalAuth.encrypt(userId)

                encrypted.should {
                    it.iv::class shouldBe ByteArray::class
                    it.secret::class shouldBe ByteArray::class
                }
            }
        }
    }

    describe("findUserId 메소드는") {
        context("encrypt HttpServletRequest에 iv와 secret값이 있다면") {
            val userId = 123456789L
            val encrypted = internalAuth.encrypt(userId)

            every { httpServletRequest.getHeader(INTERNAL_AUTH_IV_KEY) } returns Base64.getEncoder()
                .encodeToString(encrypted.iv)
            every { httpServletRequest.getHeader(INTERNAL_AUTH_SECRET_KEY) } returns Base64.getEncoder()
                .encodeToString(encrypted.secret)

            it("userId를 응답한다") {
                val expected = internalAuth.findUserId()

                expected shouldBe userId
            }
        }

        context("encrypt HttpServletRequest에 iv, secret이 없고 token이 있다면") {
            val userId = 12345678L

            every { httpServletRequest.getHeader(any()) } returns null
            every { httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION) } returns "Bearer ..."
            every { internalAuthClient.getUserByToken(any()) } returns UserResponse(userId.toString())

            it("userId를 응답한다") {
                val expected = internalAuth.findUserId()

                expected shouldBe userId
            }
        }
    }
})
