package com.idogo.data.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module
import javax.sql.DataSource

val databaseModule = module(createdAtStart = true) {
    single {
        val datasource = get<DataSource>()
        logger.info("start connect database: $datasource")
        Database.connect(datasource)
    }
    single<DataSource> {
        val properties = get<DataSourceProperties>()
        HikariConfig().apply {
            driverClassName = properties.driver
            jdbcUrl = properties.url
            username = properties.username
            password = properties.password
            maximumPoolSize = properties.connectionPoolSize
        }.let(::HikariDataSource)
    }
}