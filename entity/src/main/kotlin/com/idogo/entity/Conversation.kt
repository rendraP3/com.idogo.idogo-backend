package com.idogo.entity

import java.time.Instant

class Conversation(
    val id: Long = 0,
    val authorId: Long,
    val userIds: List<Long>,
    val groupId: Long,
    val name: String,
    val type: Int,
    val createdAt: Instant,
    val updatedAt: Instant? = null
)