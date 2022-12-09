package com.idogo.entity

import java.time.Instant

class Status(
    val id: Long = 0,
    val userId: Long = 0,
    val statusBody: String? = null,
    val attachment: String? = null,
    val type: Int,
    val expiryAt: Instant,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)