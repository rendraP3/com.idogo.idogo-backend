package com.idogo.data.config

data class DataSourceProperties(
    val url: String,
    val driver: String,
    val username: String,
    val password: String,
    val connectionPoolSize: Int
)