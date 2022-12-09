package com.idogo.usecase.conversation

import com.idogo.usecase.UseCase
import com.idogo.usecase.conversation.dto.Conversation
import com.idogo.usecase.conversation.dto.toDto
import com.idogo.usecase.conversation.repository.ConversationRepository

@UseCase
class GetAllConversationByIdUseCase(private val repository: ConversationRepository) {
    suspend operator fun invoke(id: Long, page: Long, size: Int): List<Conversation> {
        return repository.findAllById(id,page,size).map { it.toDto() }
    }
}