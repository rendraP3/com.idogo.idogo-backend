package com.idogo.usecase.conversation

import com.idogo.usecase.UseCase
import com.idogo.usecase.conversation.repository.ConversationRepository

@UseCase
class DeleteConversationUseCase (
    private val repository: ConversationRepository
        ) {
    suspend operator fun invoke(id: Long) = repository.delete(id)
}