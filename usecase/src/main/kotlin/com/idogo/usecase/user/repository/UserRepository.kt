package com.idogo.usecase.user.repository

import com.idogo.entity.User

private const val DEFAULT_OFFSET: Long = 0
private const val DEFAULT_PAGE_SIZE = 20

interface UserRepository {
    suspend fun findAll(offset: Long = DEFAULT_OFFSET, size: Int = DEFAULT_PAGE_SIZE): List<User>

    suspend fun findById(id: Long): User?

    suspend fun findByPhoneNumber(phoneNumber: String): User?

    suspend fun save(user: User): User

    suspend fun update(user: User): User

    suspend fun exist(phoneNumber: String): Boolean

    suspend fun deleteById(id: Long)
}