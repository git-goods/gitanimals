package org.gitanimals.rank.controller

import org.gitanimals.rank.app.GetRankByUsernameFacade
import org.gitanimals.rank.app.RankQueryFacade
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.response.RankResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RankController(
    private val rankQueryFacade: RankQueryFacade,
    private val getRankByUsernameFacade: GetRankByUsernameFacade,
) {

    @GetMapping("/ranks")
    fun findAllRanks(
        @RequestParam("rank") rank: Int,
        @RequestParam("size") size: Int,
        @RequestParam("type") type: RankQueryRepository.Type,
    ): List<RankResponse> = rankQueryFacade.findAllRank(rank = rank, size = size, type = type)

    @GetMapping("/ranks/by-username/{username}")
    fun findUserRankByUsername(
        @PathVariable("username") username: String,
    ): RankResponse = getRankByUsernameFacade.invoke(username)
}
