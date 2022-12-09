package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class UpdateGroupMemberUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(request: UpdateGroupMemberRequest) {
        val member = repository.findMemberById(request.id) ?: throw NotFoundException(ID_NOT_FOUND)
        member.changeIsAdmin(request.isAdmin)
        repository.updateMember(request.id, member)
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}

data class UpdateGroupMemberRequest(
    val id: Long,
    val isAdmin: Boolean
)