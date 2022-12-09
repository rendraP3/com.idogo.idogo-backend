package com.idogo.usecase.message.dto

import com.idogo.entity.Recipient as RecipientEntity
import java.time.Instant

data class Recipient(
    val id: Long,
    val messageId: Long,
    val userId: Long?,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)

fun RecipientEntity.toDto() = Recipient(id, messageId, userId, createdAt, updatedAt)