package com.idogo.entity

import java.time.Instant

class Token(
    val id: String = "",
    val userId: Long,
    val token: String,
    val expirationTime: Instant
)