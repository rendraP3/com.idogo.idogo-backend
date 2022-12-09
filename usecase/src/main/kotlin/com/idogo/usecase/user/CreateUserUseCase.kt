package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.user.dto.User
import com.idogo.usecase.user.dto.toDto
import com.idogo.entity.User as UserEntity
import com.idogo.usecase.user.repository.UserRepository
import java.time.Instant

@UseCase
class CreateUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(request: CreateUserRequest): User {
        val user = request.toEntity()
        return repository.save(user).toDto()
    }

    private fun CreateUserRequest.toEntity() = UserEntity(
        name = this.name,
        phoneNumber = this.phoneNumber,
        avatar = this.avatar,
        createdAt = Instant.now()
    )
}

data class CreateUserRequest(
    val name: String,
    val phoneNumber: String,
    val avatar: String?
)