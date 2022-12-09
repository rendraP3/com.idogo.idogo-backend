package com.idogo.usecase.message.repository

import com.idogo.entity.Attachment
import com.idogo.entity.Message
import com.idogo.entity.Recipient


interface MessageRepository {
    suspend fun findById(id: Long): Message?

    suspend fun saveMessage(message: Message, recipient: Recipient, attachment: Attachment): Message

    suspend fun update(message: Message): Message

    suspend fun remove(id: Long)
}