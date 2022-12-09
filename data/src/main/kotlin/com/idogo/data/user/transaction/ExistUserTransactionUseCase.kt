package com.idogo.data.user.transaction

import com.idogo.usecase.user.ExistUserUseCase
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class ExistUserTransactionUseCase(
    repository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): ExistUserUseCase(repository) {
    override suspend fun invoke(phoneNumber: String) = newSuspendedTransaction(dispatcher) {
        super.invoke(phoneNumber)
    }
}