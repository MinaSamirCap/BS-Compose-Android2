package com.sample.compose_bs_android2.mine.googleCredentialManager.login

data class LoginState(
    val loggedInUser: String? = null,
    val username: String = "user",
    val password: String = "pass",
    val errorMessage: String? = null,
    val isRegister: Boolean = false
)
