package com.idogo.api.controller.chat

import com.idogo.api.common.Response
import io.ktor.websocket.*
import org.koin.core.component.KoinComponent
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicInteger

class DefaultChatController(): ChatController, KoinComponent {
    override suspend fun connect(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun authorize(token: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun send(): Response {
        TODO("Not yet implemented")
    }

    companion object {
        val userCounter = AtomicInteger()
        val memberNames = ConcurrentHashMap<String, String>()
        val members = ConcurrentHashMap<String, MutableList<WebSocketSession>>()
        val lastMessages = LinkedList<String>()
    }
}

interface ChatController {
    suspend fun connect(): Response
    suspend fun authorize(token: String): Boolean
    suspend fun send(): Response
}