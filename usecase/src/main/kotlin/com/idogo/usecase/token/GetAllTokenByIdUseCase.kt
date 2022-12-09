package com.idogo.usecase.token

import com.idogo.usecase.UseCase
import com.idogo.usecase.token.dto.Token
import com.idogo.usecase.token.dto.toDto
import com.idogo.usecase.token.repository.TokenRepository

@UseCase
class GetAllTokenByIdUseCase(
    private val repository: TokenRepository
) {
    suspend operator fun invoke(id: Long): List<Token> {
        return repository.getAllById(id).map { it.toDto() }
    }
}