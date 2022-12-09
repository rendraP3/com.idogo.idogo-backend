package com.idogo.usecase.token.dto

import com.idogo.entity.Token as TokenEntity
import java.time.Instant

data class Token(
    val id: String,
    val userId: Long,
    val token: String,
    val expireAt: Instant
)

fun TokenEntity.toDto() = Token(id, userId, token, expirationTime)