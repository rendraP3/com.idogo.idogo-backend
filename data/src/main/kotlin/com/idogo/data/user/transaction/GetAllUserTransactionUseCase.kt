package com.idogo.data.user.transaction

import com.idogo.usecase.user.GetAllUserUseCase
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class GetAllUserTransactionUseCase(
    repository: UserRepository,
    private val dispatcher: CoroutineDispatcher
): GetAllUserUseCase(repository) {
    override suspend fun invoke(page: Long, size: Int) = newSuspendedTransaction(dispatcher) {
        super.invoke(page, size)
    }
}