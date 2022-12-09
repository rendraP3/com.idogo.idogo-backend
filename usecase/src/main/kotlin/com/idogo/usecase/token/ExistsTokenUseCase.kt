package com.idogo.usecase.token

import com.idogo.usecase.UseCase
import com.idogo.usecase.token.repository.TokenRepository

@UseCase
class ExistsTokenUseCase(
    private val repository: TokenRepository
) {
    suspend operator fun invoke(request: ExistTokenRequest) = repository.exists(request.id, request.token)
}

data class ExistTokenRequest(
    val id: Long,
    val token: String
)