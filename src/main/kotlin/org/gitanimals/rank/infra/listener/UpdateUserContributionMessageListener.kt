package org.gitanimals.rank.infra.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.gitanimals.core.redis.TraceableMessageListener
import org.gitanimals.rank.app.UpdateUserContributionFacade
import org.gitanimals.rank.infra.event.UserContributionUpdated
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class UpdateUserContributionMessageListener(
    private val objectMapper: ObjectMapper,
    @Qualifier("gitanimalsRedisTemplate") private val redisTemplate: StringRedisTemplate,
    private val updateUserContributionFacade: UpdateUserContributionFacade,
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

            if (userContributionUpdated.updatedContributions == 0L) {
                return
            }

            updateUserContributionFacade.updateUserWeeklyContributions(userContributionUpdated.username)
        }.onFailure {
            logger.error("Cannot update user contributions rank by message: $message", it)
            throw it
        }
    }
}
