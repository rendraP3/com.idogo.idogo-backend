package com.idogo.api

import com.idogo.api.controller.controllerModule
import com.idogo.api.v1.auth.AuthApi
import com.idogo.api.v1.call.CallApi
import com.idogo.api.v1.status.StatusApi
import com.idogo.api.v1.user.UserApi
import com.idogo.api.websocket.ChatSocket
import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModules = listOf(
    controllerModule,
    module(createdAtStart = true) {
        registerApi { AuthApi(get()) }
        registerApi { UserApi(get()) }
        registerApi { CallApi(get()) }
        registerApi { StatusApi(get()) }

        // Web Socket
        registerApi { ChatSocket(get(), get()) }
    }
)

private inline fun <reified T : Api> Module.registerApi(noinline definition: Definition<T>) =
    single<T>(definition = definition) bind Api::class