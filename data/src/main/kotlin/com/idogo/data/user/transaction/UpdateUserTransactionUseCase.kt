package com.idogo.data.user.transaction

import com.idogo.usecase.user.UpdateUserRequest
import com.idogo.usecase.user.UpdateUserUseCase
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UpdateUserTransactionUseCase(
    repository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): UpdateUserUseCase(repository) {
    override suspend fun invoke(request: UpdateUserRequest) = newSuspendedTransaction(dispatcher) {
        super.invoke(request)
    }
}