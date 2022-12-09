package com.idogo.usecase.conversation

import com.idogo.usecase.UseCase
import com.idogo.entity.Conversation as ConversationEntity
import com.idogo.usecase.conversation.dto.Conversation
import com.idogo.usecase.conversation.dto.toDto
import com.idogo.usecase.conversation.repository.ConversationRepository
import java.time.Instant

@UseCase
class CreateConversationUseCase(
    private val repository: ConversationRepository
) {
    suspend operator fun invoke(request: CreateConversationRequest): Conversation {
        val conversation = request.toEntity()
        return repository.save(conversation).toDto()
    }

    private fun CreateConversationRequest.toEntity() = ConversationEntity(
        authorId = this.authorId,
        userIds = this.userIds,
        groupId = this.groupId,
        name = this.name,
        type = this.type,
        createdAt = Instant.now()
    )
}

data class CreateConversationRequest(
    val name: String,
    val type: Int,
    val authorId: Long,
    val userIds: List<Long>,
    val groupId: Long,
)