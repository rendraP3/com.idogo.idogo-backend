package com.idogo.usecase.group.dto

import com.idogo.entity.GroupMember as GroupMemberEntity
import java.time.Instant

data class GroupMember(
    val id: Long,
    val userId: Long,
    val groupId: Long,
    val isAdmin: Boolean = false,
    val createdAt: Instant,
    val updatedAt: Instant?
)

fun GroupMemberEntity.toDto() = GroupMember(id, userId, groupId, isAdmin, createdAt, updatedAt)