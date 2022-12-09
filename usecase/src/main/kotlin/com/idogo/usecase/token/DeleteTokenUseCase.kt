package com.idogo.usecase.token

import com.idogo.usecase.UseCase
import com.idogo.usecase.token.repository.TokenRepository

@UseCase
class DeleteTokenUseCase(
    private val repository: TokenRepository
) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}