package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.group.dto.Group
import com.idogo.usecase.group.dto.toDto
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class GetGroupUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(id: Long): Group {
        val entity = repository.findById(id) ?: throw NotFoundException(ID_NOT_FOUND)
        return entity.toDto()
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}