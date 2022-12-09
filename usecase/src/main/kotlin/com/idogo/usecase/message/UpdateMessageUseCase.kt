package com.idogo.usecase.message

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.message.repository.MessageRepository

@UseCase
class UpdateMessageUseCase(
    private val repository: MessageRepository
) {

    suspend operator fun invoke(request: UpdateMessageRequest) {
        val message = repository.findById(request.id) ?: throw NotFoundException(ID_NOT_FOUND)
        message.changeIsRead(request.isRead)
        message.changeReaction(request.reaction)
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}

data class UpdateMessageRequest(
    val id: Long,
    val isRead: Boolean,
    val reaction: String
)