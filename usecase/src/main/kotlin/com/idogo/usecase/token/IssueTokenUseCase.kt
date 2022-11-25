package com.idogo.usecase.token

import com.idogo.usecase.UseCase

@UseCase
class IssueTokenUseCase(
    private val provider: TokenProvider
) {
    suspend operator fun invoke(context: Context): IssueResponse {
        return provider.issue(context)
    }
}