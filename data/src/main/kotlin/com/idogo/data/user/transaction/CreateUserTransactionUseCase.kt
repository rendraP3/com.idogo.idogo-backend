package com.idogo.data.user.transaction

import com.idogo.usecase.user.CreateUserRequest
import com.idogo.usecase.user.CreateUserUseCase
import com.idogo.usecase.user.dto.User
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class CreateUserTransactionUseCase(
    repository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): CreateUserUseCase(repository) {
    override suspend fun invoke(request: CreateUserRequest): User = newSuspendedTransaction(dispatcher) {
        super.invoke(request)
    }
}