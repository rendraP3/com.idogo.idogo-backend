package com.idogo.api.controller

import com.idogo.api.controller.auth.AuthController
import com.idogo.api.controller.auth.DefaultAuthController
import com.idogo.api.controller.call.CallController
import com.idogo.api.controller.call.DefaultCallController
import com.idogo.api.controller.chat.ChatController
import com.idogo.api.controller.chat.DefaultChatController
import com.idogo.api.controller.status.DefaultStatusController
import com.idogo.api.controller.status.StatusController
import com.idogo.api.controller.user.DefaultUserController
import com.idogo.api.controller.user.UserController
import org.koin.dsl.module

val controllerModule = module(createdAtStart = true) {
    single<AuthController> { DefaultAuthController(get(), get(), get(), get()) }
    single<UserController> { DefaultUserController(get(), get(), get(),get()) }
    single<StatusController> { DefaultStatusController() }
    single<CallController> { DefaultCallController() }

    single<ChatController> { DefaultChatController() }
}