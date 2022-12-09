package com.idogo.usecase.message

import com.idogo.usecase.UseCase
import com.idogo.usecase.message.repository.MessageRepository

@UseCase
class DeleteMessageUseCase(
    private val repository: MessageRepository
) {
    suspend operator fun invoke(id: Long) = repository.remove(id)
}