package com.idogo.api.model.request

import com.fasterxml.jackson.annotation.JsonCreator

data class RefreshTokenRequest @JsonCreator constructor(
    val token: String
)