package com.idogo.usecase.user.dto

import com.idogo.entity.User as UserEntity
import java.time.Instant

data class User(
    val id: Long,
    val name: String?,
    val phoneNumber: String?,
    val avatar: String?,
    val about: String?,
    val isVerified: Boolean = false,
    val isActive: Boolean = false,
    val createdAt: Instant?,
    val updatedAt: Instant?
)

fun UserEntity.toDto() = User(id, name, phoneNumber, avatar, about, isVerified, isActive, createdAt, updatedAt)

