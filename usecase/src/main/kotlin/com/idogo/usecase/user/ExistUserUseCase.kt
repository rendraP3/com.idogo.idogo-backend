package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.user.dto.toDto
import com.idogo.usecase.user.repository.UserRepository

@UseCase
class ExistUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(phoneNumber: String) = repository.exist(phoneNumber)
}