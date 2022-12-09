package com.idogo.data.user

import com.idogo.data.user.repository.UserDBRepository
import com.idogo.data.user.transaction.*
import com.idogo.usecase.user.*
import com.idogo.usecase.user.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val userDataModule = module {
    single<UserRepository> { UserDBRepository(Dispatchers.IO) }
    single<GetUserByIdUseCase> { GetUserTransactionByIdUseCase(get(), Dispatchers.Default) }
    single<GetUserByPhoneNumberUseCase> { GetUserByPhoneNumberTransactionUseCase(get(), Dispatchers.Default) }
    single<ExistUserUseCase> { ExistUserTransactionUseCase(get(), Dispatchers.Default) }
    single<GetAllUserUseCase> { GetAllUserTransactionUseCase(get(), Dispatchers.Default) }
    single<CreateUserUseCase> { CreateUserTransactionUseCase(get(), Dispatchers.Default) }
    single<UpdateUserUseCase> { UpdateUserTransactionUseCase(get(), Dispatchers.Default) }
    single<DeleteUserUseCase> { DeleteUserTransactionUseCase(get(), Dispatchers.Default) }
}