package org.gitanimals.rank.infra.github

import org.gitanimals.core.ratelimit.RateLimitable
import org.gitanimals.rank.app.RankContributionApi
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.nio.charset.Charset
import java.time.LocalDate
import java.time.LocalDateTime

@Component
class RankGithubContributionApi(
    @Value("\${github.token}") private val token: String,
    @Qualifier("inmemoryGithubRateLimiter") private val rateLimiter: RateLimitable,
) : RankContributionApi {

    private val restClient = RestClient.create("https://api.github.com/graphql")
    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun getContributionsBySpecificDays(
        username: String,
        from: LocalDate,
        to: LocalDate
    ): Int = rateLimiter.acquire {
        val fromString = from.toString()
        val toString = to.toString()

        return@acquire restClient.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
            .body(
                mapOf(
                    "query" to contributionCountByYearAndWeekQuery
                        .replaceFirst(NAME_FIX, username)
                        .replaceFirst(DATE_START_FIX, fromString)
                        .replaceFirst(DATE_END_FIX, toString)
                )
            ).exchange { _, response ->
                assertIsSuccess(response)

                val data =
                    response.bodyTo(ContributionCountByYearAndWeekQueryResponse::class.java)!!.data

                rateLimiter.update(
                    RateLimitable.RateLimit(
                        limit = data.rateLimit.limit,
                        remaining = data.rateLimit.remaining,
                        resetAt = data.rateLimit.resetAt,
                        used = data.rateLimit.used,
                    )
                )

                return@exchange data.user
                    .contributionsCollection
                    .contributionCalendar
                    .totalContributions
            }
    }

    private fun assertIsSuccess(response: RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse) {
        require(response.statusCode.is2xxSuccessful) {
            "Bad request cause status : \"${response.statusText}\" message : \"${
                response.bodyTo(
                    String::class.java
                )
            }\""
        }
    }

    private data class ContributionCountByYearAndWeekQueryResponse(val data: Data) {
        data class Data(
            val rateLimit: RateLimit,
            val user: User,
        ) {
            data class User(val contributionsCollection: ContributionsCollection) {
                data class ContributionsCollection(
                    val contributionCalendar: ContributionCalendar,
                ) {
                    data class ContributionCalendar(
                        val totalContributions: Int,
                    )
                }
            }

        }
    }

    class RateLimit(
        val limit: Int,
        val cost: Int,
        val remaining: Int,
        val resetAt: LocalDateTime,
        val used: Int,
    )

    companion object {
        private const val NAME_FIX = "*{name}"
        private const val DATE_START_FIX = "*{yyyy-mm-dd-start}"
        private const val DATE_END_FIX = "*{yyyy-mm-dd-end}"

        private val contributionCountByYearAndWeekQuery =
            ClassPathResource("github-graphql/contribution-count-by-year-and-week.graphql")
                .getContentAsString(Charset.defaultCharset())
    }
}
