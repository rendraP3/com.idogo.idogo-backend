package com.idogo.api.model.request

import com.fasterxml.jackson.annotation.JsonCreator

data class ChangePhoneNumberRequest @JsonCreator constructor(
    val id: Long,
    val phoneNumber: String
)