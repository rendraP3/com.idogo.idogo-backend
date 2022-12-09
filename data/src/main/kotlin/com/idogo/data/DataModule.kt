package com.idogo.data

import com.idogo.data.config.databaseModule
import com.idogo.data.config.retrofitModule
import com.idogo.data.otp.otpModule
import com.idogo.data.token.tokenModule
import com.idogo.data.user.userDataModule

val dataModules = listOf(
    databaseModule,
    userDataModule,
    tokenModule,
    retrofitModule,
    otpModule,
)