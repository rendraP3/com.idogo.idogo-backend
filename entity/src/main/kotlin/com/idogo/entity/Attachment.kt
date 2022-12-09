package com.idogo.entity

import java.time.Instant

class Attachment(
    val id: Long = 0,
    val messageId: Long = 0,
    val attachment: String,
    val mimeType: String,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)