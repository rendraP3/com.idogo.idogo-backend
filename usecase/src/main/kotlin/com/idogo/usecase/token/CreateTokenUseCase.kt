package com.idogo.usecase.token

import com.idogo.usecase.UseCase
import com.idogo.usecase.token.dto.Token
import com.idogo.usecase.token.dto.toDto
import com.idogo.entity.Token as TokenEntity
import com.idogo.usecase.token.repository.TokenRepository
import java.time.Instant

@UseCase
class CreateTokenUseCase(
    private val repository: TokenRepository
) {
    suspend operator fun invoke(request: CreateTokenRequest): Token {
        val token = request.toEntity()
        return repository.save(token).toDto()
    }

    private fun CreateTokenRequest.toEntity() = TokenEntity(
        userId = this.userId,
        token = this.token,
        expirationTime = this.expireAt
    )
}

data class CreateTokenRequest(
    val userId: Long,
    val token: String,
    val expireAt: Instant
)