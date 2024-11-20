package com.sample.compose_bs_android2.mine.googleCredentialManager.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sample.compose_bs_android2.mine.googleCredentialManager.SignInResult
import com.sample.compose_bs_android2.mine.googleCredentialManager.SignUpResult

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnPasswordChange -> {
                state = state.copy(password = action.password)
            }

            is LoginAction.OnSignUp -> {
                state = when (action.result) {
                    SignUpResult.Cancelled -> {
                        state.copy(errorMessage = "Sign up was cancelled.")
                    }

                    SignUpResult.Failure -> {
                        state.copy(errorMessage = "Sign up failed.")
                    }

                    is SignUpResult.Success -> {
                        state.copy(loggedInUser = action.result.username)
                    }
                }

            }

            is LoginAction.OnSignIn -> {
                state = when (action.result) {
                    SignInResult.Cancelled -> {
                        state.copy(errorMessage = "Sign in was cancelled.")
                    }

                    SignInResult.Failure -> {
                        state.copy(errorMessage = "Sign in failed.")
                    }

                    SignInResult.NoCredentials -> {
                        state.copy(errorMessage = "No credentials.")
                    }

                    is SignInResult.Success -> {
                        state.copy(loggedInUser = action.result.username)
                    }
                }
            }

            LoginAction.OnToggleIsRegister -> {
                state = state.copy(isRegister = !state.isRegister)
            }

            is LoginAction.OnUsernameChange -> {
                state = state.copy(username = action.username)
            }
        }
    }
}