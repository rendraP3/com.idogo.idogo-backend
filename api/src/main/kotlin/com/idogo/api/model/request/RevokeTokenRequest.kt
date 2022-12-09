package com.idogo.api.model.request

import com.fasterxml.jackson.annotation.JsonCreator

data class RevokeTokenRequest @JsonCreator constructor(
    val token: String
)