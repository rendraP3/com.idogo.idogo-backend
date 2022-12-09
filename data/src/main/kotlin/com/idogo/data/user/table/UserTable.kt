package com.idogo.data.user.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

object UserTable : LongIdTable("users") {
    val name = varchar("name", 80)
    val phoneNumber = varchar("phone_number", 20).uniqueIndex()
    val avatar = varchar("avatar", 255).nullable()
    val about = text("about").nullable()
    val isVerified = bool("isVerified").default(false)
    val isActive = bool("isActive").default(false)
    val createdAt = timestamp("createdAt")
    val updatedAt = timestamp("updatedAt").nullable()
}