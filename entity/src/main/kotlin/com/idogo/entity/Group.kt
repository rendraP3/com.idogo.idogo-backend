package com.idogo.entity

import java.time.Instant

class Group(
    val id: Long = 0,
    name: String?,
    avatar: String?,
    about: String?,
    val members: List<GroupMember>? = null,
    val authorId: Long,
    val createdAt: Instant,
    val updatedAt: Instant? = null
) {
    var name = name
        private set

    var avatar = avatar
        private set

    var about = about
        private set

    fun changeName(name: String?) {
        this.name = name
    }

    fun changeAvatar(avatar: String?) {
        this.avatar = avatar
    }

    fun changeAbout(about: String?) {
        this.about = about
    }
}