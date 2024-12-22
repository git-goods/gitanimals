package org.gitanimals.guild.app.event

import org.gitanimals.guild.core.clock
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
                    redirectTo = "",
                )
            )
        }

        fun guildJoinRequest(
            userId: Long,
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
                    redirectTo = "",
                )
            )
        }

        fun sentJoinRequest(
            userId: Long,
            guildTitle: String,
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
                    image = "guild-image", // guild 이미지 추가
                    redirectTo = "",
                )
            )
        }
    }
}
