package com.idogo.usecase.conversation.repository

import com.idogo.entity.Conversation

private const val DEFAULT_OFFSET: Long = 0
private const val DEFAULT_PAGE_SIZE = 20

interface ConversationRepository {
    suspend fun findAllById(id: Long, offset: Long = DEFAULT_OFFSET, size: Int = DEFAULT_PAGE_SIZE): List<Conversation>

    suspend fun findById(id: Long): Conversation?

    suspend fun save(conversation: Conversation): Conversation

    suspend fun delete(id: Long)
}