package com.idogo.data.otp

import org.koin.dsl.module
import retrofit2.Retrofit

val otpModule = module(createdAtStart = true) {
    single {
        val retrofit by inject<Retrofit>()
        retrofit.create(OtpApi::class.java)
    }
}
