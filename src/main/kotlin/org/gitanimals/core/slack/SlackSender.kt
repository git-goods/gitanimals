package org.gitanimals.core.slack

import com.slack.api.Slack
import com.slack.api.methods.MethodsClient
import com.slack.api.methods.request.chat.ChatPostMessageRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SlackSender(
    @Value("\${slack.token}") slackToken: String,
) {

    private val slack: MethodsClient by lazy {
        Slack.getInstance().methods(slackToken)
    }

    fun send(channel: String, message: String) {
        val request: ChatPostMessageRequest = ChatPostMessageRequest.builder()
            .channel(channel)
            .text(message)
            .build()

        slack.chatPostMessage(request)
    }
}
