package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class DeleteGroupMemberUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(groupId: Long, userId: Long) = repository.deleteMember(groupId, userId)
}