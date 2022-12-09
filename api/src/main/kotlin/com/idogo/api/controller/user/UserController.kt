package com.idogo.api.controller.user

import com.idogo.api.common.GeneralResponse
import com.idogo.api.common.PaginationResponse
import com.idogo.api.common.Response
import com.idogo.api.model.request.ChangePhoneNumberRequest
import com.idogo.api.model.response.UserInfoResponse
import com.idogo.api.model.response.UsersResponse
import com.idogo.usecase.exception.BadRequestException
import com.idogo.usecase.exception.NotFoundException
import com.idogo.usecase.exception.UserAlreadyExistException
import com.idogo.usecase.user.*
import com.idogo.usecase.user.dto.User
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import org.koin.core.component.KoinComponent
import java.sql.SQLIntegrityConstraintViolationException

class DefaultUserController(
    private val getAllUserUseCase: GetAllUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val existUserUseCase: ExistUserUseCase,
) : UserController, KoinComponent {
    override suspend fun getAllUser(page: Long, size: Int): PaginationResponse<User> = PaginationResponse(
        page, size,
        getAllUserUseCase(page, size).toList()
    )

    override suspend fun getUser(ctx: ApplicationCall): Response {
        return try {
            ctx.principal<JWTPrincipal>()?.payload?.getClaim("user-id")?.asLong()?.let {
                getUserByIdUseCase(
                    it
                ).let { user ->
                    UserInfoResponse.success(
                        "User Data Retrieved",
                        user = user
                    )
                }
            } ?: throw NotFoundException("User not found")
        } catch (e: BadRequestException) {
            GeneralResponse.failed(e.message.orEmpty())
        } catch (e: NotFoundException) {
            GeneralResponse.notFound(e.message.orEmpty())
        }
    }

    override suspend fun changePhoneNumber(ctx: ApplicationCall, request: ChangePhoneNumberRequest): Response {
        return try {
            val exists = existUserUseCase(request.phoneNumber)
            if (!exists) {
                updateUserUseCase(
                    UpdateUserRequest(
                        id = request.id,
                        phoneNumber = request.phoneNumber
                    )
                )
                GeneralResponse.success("Phone Number Changed")
            } else throw UserAlreadyExistException("Phone number already registered")
        } catch (e: BadRequestException) {
            GeneralResponse.failed(e.message.orEmpty())
        } catch (e: UserAlreadyExistException) {
            GeneralResponse.conflict(e.message.orEmpty())
        }
    }

    override suspend fun changeAvatar(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun changeName(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun changeAbout(): Response {
        TODO("Not yet implemented")
    }
}

interface UserController {
    suspend fun getAllUser(page: Long, size: Int): PaginationResponse<User>
    suspend fun getUser(ctx: ApplicationCall): Response
    suspend fun changePhoneNumber(ctx: ApplicationCall, request: ChangePhoneNumberRequest): Response
    suspend fun changeAvatar(): Response
    suspend fun changeName(): Response
    suspend fun changeAbout(): Response
}