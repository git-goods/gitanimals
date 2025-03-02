package org.gitanimals.rank.infra

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.guild.infra.event.UserContributionUpdated
import org.gitanimals.rank.app.IdentityApi
import org.gitanimals.rank.app.RenderApi
import org.gitanimals.rank.domain.UserContributionRank
import org.gitanimals.rank.domain.UserContributionRankService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class UpdateUserContributionMessageListener(
    private val renderApi: RenderApi,
    private val identityApi: IdentityApi,
    private val objectMapper: ObjectMapper,
    private val userContributionRankService: UserContributionRankService,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
) : MessageListener {

    private val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun onMessage(message: Message, pattern: ByteArray?) {
        runCatching {
            objectMapper.readValue(
                redisTemplate.stringSerializer.deserialize(message.body),
                UserContributionUpdated::class.java,
            )
        }.onSuccess {
            val user = identityApi.getUserByName(it.username)
            val renderUserWithTopLevelPersona =
                renderApi.getUserWithTopLevelPersona(username = it.username)

            val updatedUserContributionRank = UserContributionRank.create(
                image = user.profileImage,
                userId = user.id.toLong(),
                username = user.username,
                totalContributions = renderUserWithTopLevelPersona.totalContributions.toLong(),
            )

            userContributionRankService.updateContribution(updatedUserContributionRank)
        }.onFailure {
            logger.error("Cannot update user contributions rank by message: $message", it)
            throw it
        }
    }
}
