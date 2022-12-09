package com.idogo.data.user.transaction

import com.idogo.usecase.user.DeleteUserUseCase
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class DeleteUserTransactionUseCase(
    repository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): DeleteUserUseCase(repository) {
    override suspend fun invoke(id: Long) = newSuspendedTransaction(dispatcher) {
        super.invoke(id)
    }
}