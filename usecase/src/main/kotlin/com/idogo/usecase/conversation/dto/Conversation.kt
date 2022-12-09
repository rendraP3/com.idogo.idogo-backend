package com.idogo.usecase.conversation.dto

import com.idogo.entity.Conversation as ConversationEntity
import java.time.Instant

data class Conversation(
    val id: Long,
    val authorId: Long,
    val userIds: List<Long>,
    val groupId: Long,
    val name: String,
    val type: Int,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)

fun ConversationEntity.toDto() = Conversation(id, authorId, userIds, groupId, name, type, createdAt, updatedAt)