package com.idogo.entity

import java.time.Instant

class Message(
    val id: Long = 0,
    val authorId: Long = 0,
    val conversationId: Long = 0,
    val parentMessageId: Long?,
    messageBody: String,
    isRead: Boolean = false,
    reaction: String? = null,
    val expiryDate: Instant,
    val createdAt: Instant,
    val updatedAt: Instant? = null,
    val attachment: Attachment? = null,
    val recipient: Recipient? = null
) {
    var messageBody = messageBody
        private set

    var isRead = isRead
        private set

    var reaction = reaction
        private set

    fun changeMessageBody(body: String) {
        this.messageBody = body
    }

    fun changeIsRead(isRead: Boolean) {
        this.isRead = isRead
    }

    fun changeReaction(reaction: String) {
        this.reaction = reaction
    }
}