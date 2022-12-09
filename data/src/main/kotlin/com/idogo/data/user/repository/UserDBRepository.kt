package com.idogo.data.user.repository

import com.idogo.data.user.table.UserTable
import com.idogo.entity.User
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserDBRepository(
    private val dispatcher: CoroutineDispatcher
) : UserRepository {
    override suspend fun findAll(offset: Long, size: Int) = withContext(dispatcher) {
        UserTable.selectAll().limit(size, offset)
    }.map { it.toEntity() }

    override suspend fun findById(id: Long) = withContext(dispatcher) {
        UserTable.select { UserTable.id.eq(id) }.singleOrNull()?.toEntity()
    }

    override suspend fun findByPhoneNumber(phoneNumber: String) = withContext(dispatcher) {
        UserTable.select { UserTable.phoneNumber.eq(phoneNumber) }.singleOrNull()?.toEntity()
    }

    override suspend fun save(user: User): User {
        val result = withContext(dispatcher) {
            UserTable.insert {
                it[name] = user.name.orEmpty()
                it[phoneNumber] = user.phoneNumber.orEmpty()
                it[avatar] = user.avatar
                it[about] = user.about
                it[isVerified] = user.isVerified
                it[isActive] = true
                it[createdAt] = user.createdAt
                it[updatedAt] = user.updatedAt
            }
        }

        return User(
            result[UserTable.id].value,
            result[UserTable.name],
            result[UserTable.phoneNumber],
            result[UserTable.avatar],
            result[UserTable.about],
            result[UserTable.isVerified],
            result[UserTable.isActive],
            result[UserTable.createdAt],
            result[UserTable.updatedAt],
        )
    }

    override suspend fun update(user: User): User {
        withContext(dispatcher) {
            UserTable.update({ UserTable.id.eq(user.id) }) {
                if (user.name != null) it[name] = user.name.orEmpty()
                if (user.phoneNumber != null) it[phoneNumber] = user.phoneNumber.orEmpty()
                if (user.avatar != null) it[avatar] = user.avatar
                if (user.about != null) it[about] = user.about
                it[isVerified] = user.isVerified
                it[isActive] = user.isActive
                if (user.updatedAt != null) it[updatedAt] = user.updatedAt
            }
        }
        return user
    }

    override suspend fun exist(phoneNumber: String): Boolean = withContext(dispatcher) {
        UserTable.select { UserTable.phoneNumber.eq(phoneNumber) }.firstOrNull() != null
    }

    override suspend fun deleteById(id: Long) {
        withContext(dispatcher) {
            UserTable.deleteWhere { UserTable.id.eq(id) }
        }
    }

    private fun ResultRow.toEntity() = User(
        this[UserTable.id].value,
        this[UserTable.name],
        this[UserTable.phoneNumber],
        this[UserTable.avatar],
        this[UserTable.about],
        this[UserTable.isVerified],
        this[UserTable.isActive],
        this[UserTable.createdAt],
        this[UserTable.updatedAt],
    )

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }

}