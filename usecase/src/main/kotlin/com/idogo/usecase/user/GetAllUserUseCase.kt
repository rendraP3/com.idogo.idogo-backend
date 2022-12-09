package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.user.dto.User
import com.idogo.usecase.user.dto.toDto
import com.idogo.usecase.user.repository.UserRepository

@UseCase
class GetAllUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(page: Long, size: Int): List<User> {
        return repository.findAll(page, size).map { it.toDto() }
    }
}