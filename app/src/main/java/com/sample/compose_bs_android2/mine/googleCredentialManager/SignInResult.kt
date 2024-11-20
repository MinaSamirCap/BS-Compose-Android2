package com.sample.compose_bs_android2.mine.googleCredentialManager

sealed interface SignInResult {
    data class Success(val username: String, val password: String) : SignInResult
    data object Cancelled : SignInResult
    data object Failure : SignInResult
    data object NoCredentials : SignInResult
}