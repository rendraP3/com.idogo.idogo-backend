package com.idogo.usecase.status.dto

import com.idogo.entity.Status as StatusEntity
import java.time.Instant

data class Status(
    val id: Long,
    val userId: Long,
    val statusBody: String?,
    val attachment: String?,
    val type: Int,
    val expiryAt: Instant,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)

fun StatusEntity.toDto() = Status(id, userId, statusBody, attachment, type, expiryAt, createdAt, updatedAt)