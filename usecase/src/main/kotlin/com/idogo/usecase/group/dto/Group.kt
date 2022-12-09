package com.idogo.usecase.group.dto

import com.idogo.entity.GroupMember
import com.idogo.entity.Group as GroupEntity
import java.time.Instant

data class Group(
    val id: Long,
    val name: String?,
    val avatar: String?,
    val about: String?,
    val authorId: Long,
    val members: List<GroupMember>?,
    val createdAt: Instant,
    val updatedAt: Instant?
)

fun GroupEntity.toDto() = Group(id, name, avatar, about, authorId, members, createdAt, updatedAt)