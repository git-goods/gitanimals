package org.gitanimals.guild.app.event

import org.gitanimals.core.clock
import java.time.Instant

data class InboxInputEvent(
    val inboxData: InboxData,
    val publisher: Publisher,
) {

    data class Publisher(
        val publisher: String,
        val publishedAt: Instant,
    )

    data class InboxData(
        val userId: Long,
        val type: String = "INBOX",
        val title: String,
        val body: String,
        val image: String,
        val redirectTo: String,
    )

    companion object {

        fun newUserJoined(
            userId: Long,
            newUserImage: String,
            newUserName: String,
            guildId: Long,
            guildTitle: String,
        ): InboxInputEvent {
            return InboxInputEvent(
                publisher = Publisher(
                    publisher = "GUILD",
                    publishedAt = clock.instant(),
                ),
                inboxData = InboxData(
                    userId = userId,
                    title = "New user join",
                    body = "$newUserName join $guildTitle guild.",
                    image = newUserImage,
                    redirectTo = "/guild/$guildId",
                )
            )
        }

        fun guildJoinRequest(
            userId: Long,
            guildId: Long,
            newUserImage: String,
            newUserName: String,
            guildTitle: String,
        ): InboxInputEvent {
            return InboxInputEvent(
                publisher = Publisher(
                    publisher = "GUILD",
                    publishedAt = clock.instant(),
                ),
                inboxData = InboxData(
                    userId = userId,
                    title = "Guild join request",
                    body = "$newUserName has sent a join request to the $guildTitle guild.",
                    image = newUserImage,
                    redirectTo = "/guild/$guildId/setting/member",
                )
            )
        }

        fun sentJoinRequest(
            userId: Long,
            guildId: Long,
            guildTitle: String,
            guildIcon: String,
        ): InboxInputEvent {
            return InboxInputEvent(
                publisher = Publisher(
                    publisher = "GUILD",
                    publishedAt = clock.instant(),
                ),
                inboxData = InboxData(
                    userId = userId,
                    title = "Guild join request sent",
                    body = "Guild join request sent to $guildTitle.",
                    image = guildIcon,
                    redirectTo = "/guild/detail/$guildId",
                )
            )
        }
    }
}
