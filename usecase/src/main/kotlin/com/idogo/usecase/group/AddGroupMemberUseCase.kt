package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.group.dto.GroupMember
import com.idogo.usecase.group.dto.toDto
import com.idogo.entity.GroupMember as GroupMemberEntity
import com.idogo.usecase.group.repository.GroupRepository
import java.time.Instant

@UseCase
class AddGroupMemberUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(request: AddGroupMemberRequest): GroupMember {
        val member = request.toEntity()
        return repository.addMember(member.groupId, member).toDto()
    }

    private fun AddGroupMemberRequest.toEntity() = GroupMemberEntity(
        userId = this.userId,
        groupId = this.groupId,
        isAdmin = false,
        createdAt = Instant.now()
    )
}

data class AddGroupMemberRequest(
    val userId: Long,
    val groupId: Long
)