package com.idogo.api.common

interface Response {
    val status: State
    val message: String
}

enum class State {
    SUCCESS, NOT_FOUND, FAILED, UNAUTHORIZED, CONFLICT
}