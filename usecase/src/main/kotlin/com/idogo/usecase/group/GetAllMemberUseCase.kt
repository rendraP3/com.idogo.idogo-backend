package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.group.dto.GroupMember
import com.idogo.usecase.group.dto.toDto
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class GetAllMemberUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(page: Long, size: Int): List<GroupMember> {
        return repository.findAllMember(page, size).map { it.toDto() }
    }
}