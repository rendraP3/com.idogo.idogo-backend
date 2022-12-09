package com.idogo.usecase.token.repository

import com.idogo.usecase.token.dto.Context
import com.idogo.usecase.token.dto.IssueResponse

interface TokenProvider {
    suspend fun issue(context: Context): IssueResponse
    suspend fun verifyTokenType(token: String): String
}