package org.gitanimals.guild.saga

import org.gitanimals.guild.domain.GuildService
import org.gitanimals.guild.saga.event.UserContributionUpdated
import org.rooftop.netx.api.SagaCommitEvent
import org.rooftop.netx.api.SagaCommitListener
import org.rooftop.netx.meta.SagaHandler

@SagaHandler
class UpdateGuildContributionSagaHandler(
    private val guildService: GuildService,
) {

    @SagaCommitListener(
        event = UserContributionUpdated::class,
        noRollbackFor = [Throwable::class],
    )
    fun updateGuildContributions(sagaCommitEvent: SagaCommitEvent) {
        val userContributionUpdated = sagaCommitEvent.decodeEvent(UserContributionUpdated::class)

        guildService.updateContribution(
            username = userContributionUpdated.username,
            contributions = userContributionUpdated.contributions.toLong(),
        )
    }
}
