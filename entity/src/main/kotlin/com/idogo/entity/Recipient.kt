package com.idogo.entity

import java.time.Instant

class Recipient(
    val id: Long = 0,
    val messageId: Long,
    val userId: Long? = null,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)