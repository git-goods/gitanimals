package org.gitanimals.rank.app

import org.gitanimals.core.IdGenerator
import org.gitanimals.rank.domain.GuildContributionRankService
import org.gitanimals.rank.domain.RankQueryRepository
import org.gitanimals.rank.domain.RankQueryRepository.Type.WEEKLY_GUILD_CONTRIBUTIONS
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class GivePointToGuildFacade(
    private val guildApi: GuildApi,
    private val identityApi: IdentityApi,
    private val rankQueryRepository: RankQueryRepository,
    private val guildContributionRankService: GuildContributionRankService,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    @Scheduled(cron = "0 0 23 * * SUN")
    fun givePointsToGuildUsers() {
        val guildRankWithIds = rankQueryRepository.findAllRank(
            rankStartedAt = 0,
            limit = 2,
            type = WEEKLY_GUILD_CONTRIBUTIONS,
        ).associate { it.rank to it.id }

        val guildRanks = guildContributionRankService.findAllByRankIds(guildRankWithIds)

        guildRanks.forEach { rankResponse ->
            runCatching {
                val point = when {
                    rankResponse.rank == 0 -> 3_000
                    rankResponse.rank == 1 -> 2_000
                    rankResponse.rank == 2 -> 1_000
                    else -> 0
                }

                val guild = guildApi.getGuildByTitle(rankResponse.name)
                givePointToLeader(guild, point)
                givePointToMembers(guild, point)
            }.onFailure {
                logger.error("Cannot give point to guild. rank info: \"${rankResponse}\"", it)
            }
        }

        guildContributionRankService.initialWeeklyRanks()
        rankQueryRepository.initialRank(WEEKLY_GUILD_CONTRIBUTIONS)
    }

    private fun givePointToLeader(guild: GuildApi.GuildResponse, point: Int) {
        runCatching {
            identityApi.increaseUserPointsByUsername(
                username = guild.leader.name,
                point = point,
                idempotencyKey = IdGenerator.generate().toString(),
            )
        }.onFailure {
            logger.error("Cannot give point to guild leader. point: \"$point\", leader name: \"${guild.leader.name}\"", it)
        }
    }

    private fun givePointToMembers(guild: GuildApi.GuildResponse, point: Int) {
        guild.members.forEach { member ->
            runCatching {
                identityApi.increaseUserPointsByUsername(
                    member.name,
                    point = point,
                    idempotencyKey = IdGenerator.generate().toString(),
                )
            }.onFailure {
                logger.error("Cannot give point to guild member. point: \"$point\", member name: \"${member.name}\"", it)
            }
        }
    }
}
