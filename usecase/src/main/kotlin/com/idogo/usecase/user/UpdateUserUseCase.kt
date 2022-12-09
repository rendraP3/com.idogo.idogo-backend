package com.idogo.usecase.user

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.user.repository.UserRepository
import java.time.Instant

@UseCase
class UpdateUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(request: UpdateUserRequest) {
        val user = repository.findById(request.id) ?: throw NotFoundException(ID_NOT_FOUND)
        if (!request.name.isNullOrBlank()) user.changeName(request.name)
        if (!request.phoneNumber.isNullOrBlank()) user.changePhoneNumber(request.phoneNumber)
        if (!request.avatar.isNullOrBlank()) user.changeAvatar(request.avatar)
        if (request.isVerified != null) user.changeVerified(request.isVerified)
        if (request.isActive != null) user.changeActive(request.isActive)
        if (!request.about.isNullOrBlank()) user.changeAbout(request.about)

        user.changeUpdateAt(Instant.now())
        repository.update(user)
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}

data class UpdateUserRequest(
    val id: Long,
    val name: String? = null,
    val phoneNumber: String? = null,
    val avatar: String? = null,
    val about: String? = null,
    val isVerified: Boolean? = false,
    val isActive: Boolean? = false,
)