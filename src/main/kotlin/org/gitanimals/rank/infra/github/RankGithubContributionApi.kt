package org.gitanimals.rank.infra.github

import org.gitanimals.rank.app.RankContributionApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.nio.charset.Charset
import java.time.LocalDate
import java.util.concurrent.Executors

@Component
class RankGithubContributionApi(
    @Value("\${github.token}") private val token: String
) : RankContributionApi {

    private val restClient = RestClient.create("https://api.github.com/graphql")
    private val executors = Executors.newFixedThreadPool(50)

    override fun getContributionsBySpecificDays(username: String, from: LocalDate, to: LocalDate): Int {
        val fromString = from.toString()
        val toString = from.toString()

        return restClient.post()
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

                response.bodyTo(ContributionCountByYearAndWeekQueryResponse::class.java)!!
                    .data
                    .user
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
        class Data(val user: User) {
            class User(val contributionsCollection: ContributionsCollection) {
                class ContributionsCollection(
                    val contributionCalendar: ContributionCalendar,
                ) {
                    class ContributionCalendar(
                        val totalContributions: Int,
                    )
                }
            }

        }
    }

    companion object {
        private const val NAME_FIX = "*{name}"
        private const val DATE_START_FIX = "*{yyyy-mm-dd-start}"
        private const val DATE_END_FIX = "*{yyyy-mm-dd-end}"

        private val contributionCountByYearAndWeekQuery =
            ClassPathResource("github-graphql/contribution-count-by-year-and-week.graphql")
                .getContentAsString(Charset.defaultCharset())
    }
}
