package com.idogo.api.model.request

import com.fasterxml.jackson.annotation.JsonCreator

data class SignInRequest @JsonCreator constructor(
    val phoneNumber: String
)