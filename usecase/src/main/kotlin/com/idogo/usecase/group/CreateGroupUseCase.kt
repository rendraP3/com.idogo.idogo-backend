package com.idogo.usecase.group

import com.idogo.entity.GroupMember
import com.idogo.usecase.UseCase
import com.idogo.usecase.group.dto.Group
import com.idogo.usecase.group.dto.toDto
import com.idogo.entity.Group as GroupEntity
import com.idogo.usecase.group.repository.GroupRepository
import java.time.Instant

@UseCase
class CreateGroupUseCase(
    val repository: GroupRepository
) {
    suspend operator fun invoke(request: CreateGroupRequest): Group {
        val group = request.toEntity()
        return repository.save(group).toDto()
    }

    private fun CreateGroupRequest.toEntity() = GroupEntity(
        name = this.name,
        avatar = this.avatar,
        about = this.about,
        authorId = this.authorId,
        createdAt = Instant.now(),
        members = this.members?.map {
            GroupMember(
                userId = it.userId,
                groupId = it.groupId,
                createdAt = Instant.now()
            )
        }
    )
}

data class CreateGroupRequest(
    val name: String,
    val authorId: Long,
    val avatar: String?,
    val about: String?,
    val members: List<CreateGroupMemberRequest>?
)

data class CreateGroupMemberRequest(
    val userId: Long,
    val groupId: Long,
)