package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class UpdateGroupUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(request: UpdateGroupRequest) {
        val group = repository.findById(request.id) ?: throw NotFoundException(ID_NOT_FOUND)
        group.changeAbout(request.about)
        group.changeName(request.name)
        group.changeAvatar(request.avatar)
        repository.update(group)
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}

data class UpdateGroupRequest(
    val id: Long,
    val name: String?,
    val about: String?,
    val avatar: String?
)