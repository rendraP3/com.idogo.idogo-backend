package com.idogo.usecase.status

import com.idogo.usecase.UseCase
import com.idogo.usecase.status.dto.Status
import com.idogo.usecase.status.dto.toDto
import com.idogo.entity.Status as StatusEntity
import com.idogo.usecase.status.repository.StatusRepository
import java.time.Instant

@UseCase
class CreateStatusUseCase(
    private val repository: StatusRepository
) {
    suspend operator fun invoke(request: CreateStatusRequest): Status {
        val status = request.toEntity()
        return repository.save(status).toDto()
    }

    private fun CreateStatusRequest.toEntity() = StatusEntity(
        userId = this.userId,
        statusBody = this.statusBody,
        attachment = this.attachment,
        type = this.type,
        expiryAt = Instant.now(),
        createdAt = Instant.now()
    )
}

data class CreateStatusRequest(
    val userId: Long,
    val statusBody: String?,
    val attachment: String?,
    val type: Int
)