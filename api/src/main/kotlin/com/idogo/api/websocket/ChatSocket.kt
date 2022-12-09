package com.idogo.api.websocket

import com.idogo.api.Api
import com.idogo.api.common.Connection
import com.idogo.api.controller.chat.ChatController
import com.idogo.data.token.manager.SharedSecretTokenManager
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.util.*

class ChatSocket(
    private val chatController: ChatController,
    private val tokenManager: SharedSecretTokenManager,
): Api({
    val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())
    webSocket("/chat") {
        val token = call.parameters["token"]
//        val verify = tokenManager.verify(token)
        for (frame in incoming) {
            frame as? Frame.Text ?: continue
            val receivedText = frame.readText()
            if (receivedText.equals("bye", ignoreCase = true)) {
                close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
            } else {
                send(Frame.Text("Hi, $receivedText!"))
            }
        }
    }
})