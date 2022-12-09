package com.idogo.api.model.request

import com.fasterxml.jackson.annotation.JsonCreator

data class SignUpRequest @JsonCreator constructor(
    val name: String,
    val phoneNumber: String,
    val avatar: String? = null
)