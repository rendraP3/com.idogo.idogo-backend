package com.idogo.usecase.status.repository

import com.idogo.entity.Status

private const val DEFAULT_OFFSET: Long = 0
private const val DEFAULT_PAGE_SIZE = 20

interface StatusRepository {
    suspend fun findAll(offset: Long = DEFAULT_OFFSET, size: Int = DEFAULT_PAGE_SIZE): List<Status>

    suspend fun findById(id: Long): Status?

    suspend fun save(status: Status): Status

    suspend fun delete(id: Long)
}