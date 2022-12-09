package com.idogo.usecase.message.dto

import com.idogo.entity.Attachment as AttachmentEntity
import java.time.Instant

data class Attachment(
    val id: Long,
    val messageId: Long,
    val attachment: String,
    val mimeType: String,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)

fun AttachmentEntity.toDto() = Attachment(id, messageId, attachment, mimeType, createdAt, updatedAt)