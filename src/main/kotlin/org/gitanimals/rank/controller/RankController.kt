package org.gitanimals.rank.controller

import org.gitanimals.core.ErrorResponse
import org.gitanimals.rank.app.GetRankByUsernameFacade
import org.gitanimals.rank.app.RankQueryFacade
import org.gitanimals.rank.controller.response.RankHistoryResponse
import org.gitanimals.rank.controller.response.RankTotalCountResponse
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.history.RankHistoryService
import org.gitanimals.rank.domain.response.RankResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RankController(
    private val rankQueryFacade: RankQueryFacade,
    private val getRankByUsernameFacade: GetRankByUsernameFacade,
    private val rankHistoryService: RankHistoryService,
) {

    @GetMapping("/ranks")
    fun findAllRanks(
        @RequestParam("rank") rank: Int,
        @RequestParam("size") size: Int,
        @RequestParam("type") rankType: RankQueryRepository.RankType,
    ): List<RankResponse> =
        rankQueryFacade.findAllRank(rank = rank, size = size, rankType = rankType)

    @GetMapping("/ranks/by-username/{username}")
    fun findUserRankByUsername(
        @PathVariable("username") username: String,
    ): ResponseEntity<out Any> {
        return runCatching {
            ResponseEntity.ok(getRankByUsernameFacade.invoke(username))
        }.getOrElse {
            ResponseEntity
                .badRequest()
                .body(
                    ErrorResponse("Cannot find rank by username: \"$username\"")
                )
        }
    }

    @GetMapping("/ranks/histories")
    fun getRankHistoryByRankType(
        @RequestParam rankType: RankQueryRepository.RankType,
    ): RankHistoryResponse {
        val rankHistories = rankHistoryService.findTop3HistoryByRankType(rankType)

        return RankHistoryResponse.from(rankHistories)
    }

    @GetMapping("/ranks/total")
    fun getTotalRankCountsByRankType(
        @RequestParam("type") rankType: RankQueryRepository.RankType,
    ): RankTotalCountResponse =
        RankTotalCountResponse(rankQueryFacade.findRankTotalCountByRankType(rankType))
}
