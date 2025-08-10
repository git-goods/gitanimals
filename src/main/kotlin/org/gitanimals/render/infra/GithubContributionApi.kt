package org.gitanimals.render.infra

import org.gitanimals.render.app.ContributionApi
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.nio.charset.Charset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

@Component
class GithubContributionApi(
    @Value("\${github.token}") private val token: String
) : ContributionApi {

    private val restClient = RestClient.create("https://api.github.com/graphql")
    private val executors = Executors.newFixedThreadPool(50)

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun getContributionCount(username: String, years: List<Int>): Map<Int, Int> {
        val contributionCountResponses = runCatching {
            callGetContributionCountApis(years, username)
        }.getOrElse {
            logger.warn("[GithubContributionApi] Fail to retrieve user info from github. cause: ${it.message}", it)
            throw it
        }

        val ans = mutableMapOf<Int, Int>()
        years.withIndex().forEach {
            val index = it.index
            val year = it.value
            val completableFuture = contributionCountResponses[index]
            ans[year] = completableFuture.get()
        }

        return ans
    }

    private fun callGetContributionCountApis(
        years: List<Int>,
        username: String
    ): MutableList<CompletableFuture<Int>> {
        val completableFutures = mutableListOf<CompletableFuture<Int>>()
        years.forEach { year ->
            val completableFuture = CompletableFuture.supplyAsync({
                restClient.post()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
                    .body(
                        mapOf(
                            "query" to contributionCountByYearQuery
                                .replaceFirst(NAME_FIX, username)
                                .replace(YEAR_FIX, year.toString())
                        )
                    )
                    .exchange { _, response ->
                        assertIsSuccess(response)

                        response.bodyTo(ContributionCountByYearQueryResponse::class.java)!!
                            .data
                            .user
                            .contributionsCollection
                            .contributionCalendar
                            .totalContributions
                    }
            }, executors)

            completableFutures.add(completableFuture)
        }
        return completableFutures
    }

    override fun getAllContributionYears(username: String): List<Int> {
        return restClient.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
            .body(mapOf("query" to contributionYearQuery.replace(NAME_FIX, username)))
            .exchange { _, response ->
                assertIsSuccess(response)

                response.bodyTo(ContributionYearQueryResponse::class.java)!!
                    .data
                    .user
                    .contributionsCollection
                    .contributionYears
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

    private class ContributionYearQueryResponse(val data: Data) {
        class Data(val user: User) {
            class User(val contributionsCollection: ContributionsCollection) {
                class ContributionsCollection(
                    val contributionYears: List<Int>,
                )
            }
        }
    }

    private class ContributionCountByYearQueryResponse(val data: Data) {
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
        private const val YEAR_FIX = "*{year}"

        private val contributionYearQuery: String =
            ClassPathResource("github-graphql/contribution-year.graphql")
                .getContentAsString(Charset.defaultCharset())

        private val contributionCountByYearQuery =
            ClassPathResource("github-graphql/contribution-count-by-year.graphql")
                .getContentAsString(Charset.defaultCharset())
    }
}
