package com.idogo.entity

import java.time.Instant

class GroupMember(
    val id: Long = 0,
    val userId: Long,
    val groupId: Long,
    isAdmin: Boolean = false,
    val createdAt: Instant,
    val updatedAt: Instant? = null
) {
    var isAdmin = isAdmin
        private set

    fun changeIsAdmin(isAdmin: Boolean) {
        this.isAdmin = isAdmin
    }
}