package org.gitanimals.supports.ratelimit

import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.gitanimals.core.instant
import org.gitanimals.core.ratelimit.RateLimitable
import org.gitanimals.core.slack.SlackSender
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@DisplayName("InmemoryGithubRateLimiter 클래스의")
internal class InmemoryGithubRateLimiterTest(
    @MockkBean(relaxed = true) private val slackSender: SlackSender,
) : DescribeSpec({
    describe("acquire 메소드는") {

        context("rateLimit값이 null 이라면") {
            val rateLimiter = InmemoryGithubRateLimiter(slackSender)

            it("action 메소드를 항상 성공한다") {
                val result = rateLimiter.acquire {
                    "foo"
                }

                result shouldBe "foo"
            }
        }

        context("rateLimit값이 50%로 존재할때") {
            val rateLimiter = InmemoryGithubRateLimiter(slackSender)
            rateLimiter.update(
                RateLimitable.RateLimit(
                    limit = 1000,
                    remaining = 500,
                    resetAt = LocalDateTime.ofInstant(
                        instant().plus(1, ChronoUnit.DAYS),
                        ZoneId.systemDefault(),
                    ),
                    used = 500,
                )
            )
            it("limitPercentage가 50% 초과라면 IllegalStateException 을 던진다") {
                shouldThrow<IllegalStateException> {
                    rateLimiter.acquire(limitPercent = 51.0) {
                        "foo"
                    }
                }
            }

            it("limitPercentage가 50% 이하라면, action을 수행한다") {
                val result = rateLimiter.acquire(limitPercent = 50.0) {
                    "foo"
                }

                result shouldBe "foo"
            }
        }
    }
})
