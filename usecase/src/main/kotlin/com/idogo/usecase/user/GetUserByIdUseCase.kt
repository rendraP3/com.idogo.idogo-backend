package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.user.dto.User
import com.idogo.usecase.user.dto.toDto
import com.idogo.usecase.user.repository.UserRepository

@UseCase
class GetUserByIdUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Long): User {
        val entity = repository.findById(id) ?: throw NotFoundException(ID_NOT_FOUND)
        return entity.toDto()
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}