package com.idogo.usecase.group.repository

import com.idogo.entity.Group
import com.idogo.entity.GroupMember


interface GroupRepository {

    suspend fun findById(id: Long): Group?

    suspend fun save(group: Group): Group

    suspend fun update(group: Group): Group

    suspend fun findAllMember(page: Long, size: Int): List<GroupMember>

    suspend fun findMemberById(id: Long): GroupMember?

    suspend fun addMember(id: Long, member: GroupMember): GroupMember

    suspend fun updateMember(id: Long, member: GroupMember): GroupMember

    suspend fun deleteMember(groupId: Long, memberId: Long)

    suspend fun deleteById(id: Long)

}