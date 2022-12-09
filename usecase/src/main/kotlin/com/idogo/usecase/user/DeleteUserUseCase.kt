package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.user.repository.UserRepository

@UseCase
class DeleteUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteById(id)
}