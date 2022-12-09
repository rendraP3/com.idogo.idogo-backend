package com.idogo.usecase.status

import com.idogo.usecase.UseCase
import com.idogo.usecase.status.dto.Status
import com.idogo.usecase.status.dto.toDto
import com.idogo.usecase.status.repository.StatusRepository

@UseCase
class GetAllStatusUseCase(
    private val repository: StatusRepository
) {
    suspend operator fun invoke(page: Long, size: Int): List<Status> {
        return repository.findAll(page, size).map { it.toDto() }
    }
}