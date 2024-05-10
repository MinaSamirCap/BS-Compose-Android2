package com.sample.compose_bs_android2.mine.favErrorHandler.domain

class UserDataValidator {

    fun validatePassword(password: String): Result<Unit, PasswordError> {

        if (password.length < 9) return Result.Error(PasswordError.TOO_SHORT)

        if (!password.any { it.isUpperCase() }) return Result.Error(PasswordError.NO_UPPERCASE)

        if (!password.any { it.isDigit() }) return Result.Error(PasswordError.NO_DIGITS)

        return Result.Success(Unit)
    }

    enum class PasswordError : Error {
        TOO_SHORT,
        NO_UPPERCASE,
        NO_DIGITS
    }

}