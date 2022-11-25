package com.idogo.api.common

data class PaginationResponse<T>(
    val page: Long,
    val size: Int,
    val result: List<T>
)