package com.idogo.entity

import java.time.Instant

class User(
    val id: Long = 0,
    name: String?,
    phoneNumber: String?,
    avatar: String?,
    about: String? = null,
    isVerified: Boolean = false,
    isActive: Boolean = false,
    val createdAt: Instant,
    updatedAt: Instant? = null
) {
    var name = name
        private set

    var phoneNumber = phoneNumber
        private set

    var avatar = avatar
        private set

    var about = about
        private set

    var isVerified = isVerified
        private set

    var isActive = isActive
        private set

    var updatedAt = updatedAt
        private set

    fun changeName(name: String?) {
        this.name = name
    }

    fun changePhoneNumber(phoneNumber: String?) {
        this.phoneNumber = phoneNumber
    }

    fun changeAvatar(avatar: String?) {
        this.avatar = avatar
    }

    fun changeAbout(about: String?) {
        this.about = about
    }

    fun changeVerified(isVerified: Boolean = false) {
        this.isVerified = isVerified
    }

    fun changeActive(isActive: Boolean = false) {
        this.isActive = isActive
    }

    fun changeUpdateAt(updatedAt: Instant?) {
        this.updatedAt = updatedAt
    }
}