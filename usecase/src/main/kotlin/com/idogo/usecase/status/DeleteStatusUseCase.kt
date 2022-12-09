package com.idogo.usecase.status

import com.idogo.usecase.UseCase
import com.idogo.usecase.status.repository.StatusRepository

@UseCase
class DeleteStatusUseCase(private val repository: StatusRepository) {
    suspend operator fun invoke(id: Long) = repository.delete(id)
}