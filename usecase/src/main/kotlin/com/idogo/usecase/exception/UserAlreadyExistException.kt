package com.idogo.usecase.exception

class UserAlreadyExistException : BaseException {
    constructor(msg: String): super(msg)
    constructor(msg: String, cause: Throwable): super(msg, cause)
    constructor(cause: Throwable): super(cause)
}