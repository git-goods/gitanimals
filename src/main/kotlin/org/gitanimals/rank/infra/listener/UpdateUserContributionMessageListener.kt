package org.gitanimals.rank.infra.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.core.redis.TraceableMessageListener
import org.gitanimals.rank.app.IdentityApi
import org.gitanimals.rank.domain.UserContributionRank
import org.gitanimals.rank.domain.UserContributionRankService
import org.gitanimals.rank.infra.event.UserContributionUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class UpdateUserContributionMessageListener(
    private val identityApi: IdentityApi,
    private val objectMapper: ObjectMapper,
    private val userContributionRankService: UserContributionRankService,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) : TraceableMessageListener(
    listenerName = "UpdateUserContributionMessageListener",
    objectMapper = objectMapper,
    redisTemplate = redisTemplate,
) {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message) {
        runCatching {
            val userContributionUpdated = objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                UserContributionUpdated::class.java,
            )

            val updatedUserContributionRank = runCatching {
                val user = identityApi.getUserByName(userContributionUpdated.username)

                UserContributionRank.create(
                    image = user.profileImage,
                    userId = user.id.toLong(),
                    username = user.username,
                    weeklyContributions = userContributionUpdated.updatedContributions,
                )
            }.getOrElse { return }

            userContributionRankService.updateContribution(updatedUserContributionRank)
        }.onFailure {
            logger.error("Cannot update user contributions rank by message: $message", it)
            throw it
        }
    }
}
