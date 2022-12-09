package com.idogo.data.token.table

import com.idogo.data.user.table.UserTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.timestamp

object TokenTable : UUIDTable("tokens") {
    val user = reference("user", UserTable)
    val token = varchar("token", 512)
    val expirationTime = timestamp("expiration_time")
}