package com.sample.compose_bs_android2.mine.googleCredentialManager

sealed interface SignUpResult {
    data class Success(val username: String) : SignUpResult
    data object Cancelled : SignUpResult
    data object Failure : SignUpResult
}