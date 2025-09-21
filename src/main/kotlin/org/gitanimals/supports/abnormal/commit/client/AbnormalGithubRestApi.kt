package org.gitanimals.supports.abnormal.commit.client

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

interface AbnormalGithubRestApi {

    fun String.toAuthor(): String = "author:$this"

    @GetExchange("/search/commits?sort=author-date&order=desc&per_page=20")
    fun findCommits(
        @RequestParam("q") author: String, // ex. author:devxb
        @RequestParam("per_page") perPage: Int,
    ): GithubCommitResponse

    @GetExchange("repos/{owner}/{repo}/commits/{sha}")
    fun findDiff(
        @PathVariable("owner") owner: String,
        @PathVariable("repo") repo: String,
        @PathVariable("sha") sha: String,
        @RequestHeader(HttpHeaders.ACCEPT) accept: String = "application/vnd.github.patch",
    ): String

}

data class GithubCommitResponse(
    @JsonProperty("total_count")
    val totalCount: Int,
    @JsonProperty("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<CommitItem>,
    val repository: Repository,
)

data class CommitItem(
    val url: String,
    val sha: String,
    val repository: Repository,
)

data class Repository(
    val id: Long,
)
