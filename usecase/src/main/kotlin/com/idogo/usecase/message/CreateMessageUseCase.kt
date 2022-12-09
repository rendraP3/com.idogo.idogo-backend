package com.idogo.usecase.message

import com.idogo.entity.Recipient as RecipientEntity
import com.idogo.entity.Attachment as AttachmentEntity
import com.idogo.usecase.UseCase
import com.idogo.usecase.message.dto.Message
import com.idogo.usecase.message.dto.toDto
import com.idogo.entity.Message as MessageEntity
import com.idogo.usecase.message.repository.MessageRepository
import java.time.Instant

@UseCase
class CreateMessageUseCase(
    private val repository: MessageRepository
) {
    suspend operator fun invoke(request: CreateMessageRequest): Message {
        val message = request.toEntity()
        val attachment = request.attachment.toEntity(message.id)
        val recipient = request.recipient.toEntity(message.id)
        return repository.saveMessage(message, recipient, attachment).toDto()
    }

    private fun CreateMessageRequest.toEntity() = MessageEntity(
        authorId = this.authorId,
        conversationId = this.conversationId,
        parentMessageId = this.parentMessageId,
        messageBody = this.messageBody,
        createdAt = Instant.now(),
        expiryDate = Instant.now(),
    )

    private fun CreateAttachmentRequest.toEntity(id: Long) = AttachmentEntity(
        messageId = id,
        attachment = this.attachment,
        mimeType = this.mimeType,
        createdAt = Instant.now()
    )

    private fun CreateRecipientRequest.toEntity(id: Long) = RecipientEntity(
        messageId = id,
        userId = this.userId,
        createdAt = Instant.now()
    )
}

data class CreateMessageRequest(
    val authorId: Long,
    val conversationId: Long,
    val parentMessageId: Long?,
    val messageBody: String,
    val attachment: CreateAttachmentRequest,
    val recipient: CreateRecipientRequest
)

data class CreateAttachmentRequest(
    val attachment: String,
    val mimeType: String
)

data class CreateRecipientRequest(
    val userId: Long?,
    val groupId: Long?
)