package com.idogo.data.otp

import retrofit2.http.Body
import retrofit2.http.POST

interface OtpApi {
    @POST("idogo_new/kirim_sms_otp.php")
    suspend fun sendSmsOtp()
}