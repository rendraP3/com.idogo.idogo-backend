package com.idogo.data.token.repository

import com.idogo.data.token.table.TokenTable
import com.idogo.entity.Token
import com.idogo.usecase.token.repository.TokenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*

class TokenDBRepository(
    private val dispatcher: CoroutineDispatcher
): TokenRepository {
    override suspend fun getAllById(id: Long) = withContext(dispatcher) {
        TokenTable.select { TokenTable.user.eq(id) }.map { it.toEntity() }
    }

    override suspend fun exists(id: Long, token: String) = withContext(dispatcher) {
        TokenTable.select { ((TokenTable.user.eq(id)) and (TokenTable.token.eq(token))) }
            .firstOrNull() != null
    }

    override suspend fun save(tokens: Token): Token {
       val result = withContext(dispatcher) {
           TokenTable.insert {
               it[user] = tokens.userId
               it[token] = tokens.token
               it[expirationTime] = tokens.expirationTime
           }
       }

        return Token(
            result[TokenTable.id].value.toString(),
            result[TokenTable.user].value,
            result[TokenTable.token],
            result[TokenTable.expirationTime]
        )
    }

    override suspend fun delete(id: String) {
        withContext(dispatcher) {
            TokenTable.deleteWhere { TokenTable.id.eq(UUID.fromString(id)) }
        }
    }

    private fun ResultRow.toEntity() = Token(
        this[TokenTable.id].value.toString(),
        this[TokenTable.user].value,
        this[TokenTable.token],
        this[TokenTable.expirationTime]
    )
}