package org.gitanimals.core.appender

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import com.slack.api.Slack
import com.slack.api.methods.MethodsClient
import com.slack.api.methods.request.chat.ChatPostMessageRequest

class SlackAppender : AppenderBase<ILoggingEvent>() {

    private lateinit var slack: MethodsClient

    private val errorChannel = "C080GR85WM9"
    private val warnChannel = "C08977RL38C"

    override fun append(eventObject: ILoggingEvent) {
        runCatching {
            val channel = when (eventObject.level) {
                Level.WARN -> warnChannel
                Level.ERROR -> errorChannel
                else -> NOT_LOGGING
            }

            if (channel == NOT_LOGGING) {
                return
            }

            val request: ChatPostMessageRequest = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(eventObject.formattedMessage)
                .build();
            slack.chatPostMessage(request)
        }
    }

    fun setToken(token: String) {
        this.slack = Slack.getInstance().methods(token)
    }

    companion object {
        private const val NOT_LOGGING = "NOT LOGGING"
    }
}
