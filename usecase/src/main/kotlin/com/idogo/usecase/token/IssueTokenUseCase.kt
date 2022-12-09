package com.idogo.usecase.token

import com.idogo.usecase.UseCase
import com.idogo.usecase.token.dto.Context
import com.idogo.usecase.token.dto.IssueResponse
import com.idogo.usecase.token.repository.TokenProvider

@UseCase
class IssueTokenUseCase(
    private val provider: TokenProvider
) {
    suspend operator fun invoke(context: Context): IssueResponse {
        return provider.issue(context)
    }
}