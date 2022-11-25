package com.idogo.data

import com.idogo.data.config.databaseModule
import com.idogo.data.config.retrofitModule
import com.idogo.data.otp.otpModule
import com.idogo.data.token.tokenModule

val dataModules = listOf(
    databaseModule,
    retrofitModule,
    tokenModule,
    otpModule
)