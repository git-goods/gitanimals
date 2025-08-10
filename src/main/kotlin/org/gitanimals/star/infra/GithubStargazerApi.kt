package org.gitanimals.star.infra

import com.fasterxml.jackson.annotation.JsonCreator
import org.gitanimals.core.ratelimit.RateLimitable
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.nio.charset.Charset
import java.time.LocalDateTime

@Component
@Profile("!test")
class GithubStargazerApi(
    @Value("\${github.token}") private val token: String,
    @Qualifier("inmemoryGithubRateLimiter") private val rateLimiter: RateLimitable,
) {

    private val restClient = RestClient.create("https://api.github.com/graphql")

    fun getStargazers(): List<StargazersResponse> {
        val stargazers = mutableListOf(getStargazer(""))

        while (stargazers.last().pageInfo.hasNextPage) {
            val stargazer = getStargazer(stargazers.last().pageInfo.endCursor)
            stargazers.add(stargazer)
        }

        return stargazers
    }

    private fun getStargazer(endCursor: String): StargazersResponse = rateLimiter.acquire {
        return@acquire restClient.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
            .body(
                mapOf(
                    "query" to stargazerQuery.replaceFirst("*{endCursor}", endCursor)
                )
            ).exchange { _, response ->
                assertIsSuccess(response)

                val data = response.bodyTo(GithubStargazerGraphqlResponse::class.java)!!
                    .data

                rateLimiter.update(
                    RateLimitable.RateLimit(
                        limit = data.rateLimit.limit,
                        remaining = data.rateLimit.remaining,
                        resetAt = data.rateLimit.resetAt,
                        used = data.rateLimit.used,
                    )
                )

                return@exchange data.repository.stargazers
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

    companion object {
        private val stargazerQuery: String =
            ClassPathResource("github-graphql/stargazer.graphql")
                .getContentAsString(Charset.defaultCharset())
    }
}

data class GithubStargazerGraphqlResponse @JsonCreator constructor(
    val data: Data,
) {
    data class Data @JsonCreator constructor(
        val rateLimit: RateLimit,
        val repository: Repository,
    ) {
        data class Repository @JsonCreator constructor(
            val stargazers: StargazersResponse,
        )
    }
}

data class StargazersResponse @JsonCreator constructor(
    val edges: List<StarPushedPeople>,
    val pageInfo: PageInfo,
) {

    data class StarPushedPeople @JsonCreator constructor(
        val starredAt: String,
        val node: Node,
    ) {
        data class Node @JsonCreator constructor(
            val login: String,
        )
    }

    data class PageInfo @JsonCreator constructor(
        val endCursor: String,
        val hasNextPage: Boolean,
    )
}

data class RateLimit(
    val limit: Int,
    val cost: Int,
    val remaining: Int,
    val resetAt: LocalDateTime,
    val used: Int,
)
