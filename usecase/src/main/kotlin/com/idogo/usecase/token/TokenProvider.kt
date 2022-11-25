package com.idogo.usecase.token

interface TokenProvider {
    suspend fun issue(context: Context): IssueResponse
}