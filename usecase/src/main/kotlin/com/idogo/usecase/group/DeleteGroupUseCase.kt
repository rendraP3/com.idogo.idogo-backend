package com.idogo.usecase.group

import com.idogo.usecase.UseCase
import com.idogo.usecase.group.repository.GroupRepository

@UseCase
class DeleteGroupUseCase(
    private val repository: GroupRepository
) {
    suspend operator fun invoke(id: Long) =  repository.deleteById(id)
}