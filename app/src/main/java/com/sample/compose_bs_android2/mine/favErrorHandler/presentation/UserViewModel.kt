package com.sample.compose_bs_android2.mine.favErrorHandler.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.AuthRepository
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.DataError
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.Result
import com.sample.compose_bs_android2.mine.favErrorHandler.domain.UserDataValidator
import kotlinx.coroutines.launch

class UserViewModel(
    private val userDataValidator: UserDataValidator,
    private val repository: AuthRepository
) : ViewModel() {

    fun onRegisterClick(password: String) {
        when (val result = userDataValidator.validatePassword(password)) {
            is Result.Error -> {
                when (result.error) {
                    UserDataValidator.PasswordError.TOO_SHORT -> TODO()
                    UserDataValidator.PasswordError.NO_UPPERCASE -> TODO()
                    UserDataValidator.PasswordError.NO_DIGITS -> TODO()
                }
            }

            is Result.Success -> {

            }
        }

        viewModelScope.launch {
            when (val result = repository.register(password)) {
                is Result.Error -> {
                    when(result.error){
                        DataError.Network.REQUEST_TIMEOUT -> TODO()
                        DataError.Network.TOO_MANY_REQUESTS -> TODO()
                        DataError.Network.NO_INTERNET -> TODO()
                        DataError.Network.PAYLOAD_TOO_LARGE -> TODO()
                        DataError.Network.SERVER_ERROR -> TODO()
                        DataError.Network.SERIALIZATION_ERROR -> TODO()
                        DataError.Network.UNKNOWN_ERROR -> TODO()
                    }

                }
                is Result.Success -> {
                    result.data
                }
            }
        }
    }
}


/// references ...
// https://www.youtube.com/watch?v=MiLN2vs2Oe0