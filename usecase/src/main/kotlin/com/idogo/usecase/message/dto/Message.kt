package com.idogo.usecase.message.dto

import com.idogo.entity.Attachment
import com.idogo.entity.Recipient
import com.idogo.entity.Message as MessageEntity
import java.time.Instant

data class Message(
    val id: Long,
    val authorId: Long,
    val conversationId: Long,
    val parentMessageId: Long?,
    val messageBody: String,
    val isRead: Boolean,
    val reaction: String?,
    val expiryDate: Instant,
    val createdAt: Instant,
    val updatedAt: Instant?,
    val attachment: Attachment?,
    val recipient: Recipient?
)

fun MessageEntity.toDto() = Message(
    id,
    authorId,
    conversationId,
    parentMessageId,
    messageBody,
    isRead,
    reaction,
    expiryDate,
    createdAt,
    updatedAt,
    attachment, recipient
)