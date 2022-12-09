package com.idogo.usecase.token.repository

import com.idogo.entity.Token

interface TokenRepository {
    suspend fun getAllById(id: Long): List<Token>

    suspend fun exists(id: Long, token: String): Boolean

    suspend fun save(tokens: Token): Token

    suspend fun delete(id: String)
}