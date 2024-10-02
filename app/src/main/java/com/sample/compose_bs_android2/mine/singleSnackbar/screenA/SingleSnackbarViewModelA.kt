package com.sample.compose_bs_android2.mine.singleSnackbar.screenA

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarAction
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarController
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarEvent
import kotlinx.coroutines.launch

class SingleSnackbarViewModelA : ViewModel() {

    fun showSnackbar() {
        viewModelScope.launch {
            SnackbarController.sendEvent(
                event = SnackbarEvent(
                    message = "Hello from ViewModel",
                    action = SnackbarAction(
                        name = "Hit me! :P",
                        action = {
                            viewModelScope.launch {
                                SnackbarController.sendEvent(
                                    event = SnackbarEvent(
                                        message = "Callback from snackbar"
                                    )
                                )
                            }
                        }
                    )
                )
            )
        }
    }
}