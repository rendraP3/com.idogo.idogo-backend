package com.idogo.api.controller.auth

import com.idogo.api.common.GeneralResponse
import com.idogo.api.common.Response
import com.idogo.api.model.request.SignInRequest
import com.idogo.api.model.request.SignUpRequest
import com.idogo.api.model.response.AuthResponse
import com.idogo.usecase.exception.BadRequestException
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.exception.UserAlreadyExistException
import com.idogo.usecase.token.IssueTokenUseCase
import com.idogo.usecase.token.dto.Context
import com.idogo.usecase.user.CreateUserRequest
import com.idogo.usecase.user.CreateUserUseCase
import com.idogo.usecase.user.ExistUserUseCase
import com.idogo.usecase.user.GetUserByPhoneNumberUseCase
import org.koin.core.component.KoinComponent

class DefaultAuthController(
    private val tokenIssuer: IssueTokenUseCase,
    private val getUserByPhoneNumberUseCase: GetUserByPhoneNumberUseCase,
    private val existUserUseCase: ExistUserUseCase,
    private val createUserUseCase: CreateUserUseCase,
): AuthController, KoinComponent {
    override suspend fun signIn(request: SignInRequest): Response {
        return try {
            getUserByPhoneNumberUseCase(request.phoneNumber)?.let {
                val token = tokenIssuer(Context(it.id))
                AuthResponse.success(
                    "Login successfully",
                    token.accessToken,
                    token.refreshToken
                )
            } ?: throw NotFoundException("User not found")
        } catch (e: BadRequestException) {
            GeneralResponse.failed(e.message.orEmpty())
        } catch (e: NotFoundException) {
            GeneralResponse.notFound(e.message.orEmpty())
        }
    }

    override suspend fun signUp(request: SignUpRequest): Response {
        return try {
            val exists = existUserUseCase(request.phoneNumber)
            if (!exists) {
                val user = createUserUseCase(CreateUserRequest(request.name, request.phoneNumber, request.avatar))
                val token = tokenIssuer(Context(user.id))
                AuthResponse.success(
                    "Register successfully",
                    token.accessToken,
                    token.refreshToken
                )
            } else throw UserAlreadyExistException("Phone number already registered")
        } catch (e: BadRequestException) {
            GeneralResponse.failed(e.message.orEmpty())
        } catch (e: UserAlreadyExistException) {
            GeneralResponse.conflict(e.message.orEmpty())
        }
    }

    override suspend fun refreshToken(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun revokeToken(): Response {
        TODO("Not yet implemented")
    }

}

interface AuthController {
    suspend fun signIn(request: SignInRequest): Response
    suspend fun signUp(request: SignUpRequest): Response
    suspend fun refreshToken(): Response
    suspend fun revokeToken(): Response
}