package com.sample.compose_bs_android2.mine.favErrorHandler.data

import com.sample.compose_bs_android2.mine.favErrorHandler.domain.AuthRepository
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.DataError
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.Result
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.User
import retrofit2.HttpException

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(password: String): Result<User, DataError.Network> {
        // API call logic
        return try {
            val user = User("dummy", "dummy", "dummy")
            Result.Success(user)

        } catch (e: HttpException) {
            when (e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                else -> Result.Error(DataError.Network.UNKNOWN_ERROR)
            }
        }
    }
}