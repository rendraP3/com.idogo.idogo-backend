package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.user.dto.User
import com.idogo.usecase.user.dto.toDto
import com.idogo.usecase.user.repository.UserRepository

@UseCase
class GetUserByPhoneNumberUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(phoneNumber: String): User? {
        val entity = repository.findByPhoneNumber(phoneNumber)
        return entity?.toDto()
    }

    companion object {
        private const val ID_NOT_FOUND = "User not found"
    }
}