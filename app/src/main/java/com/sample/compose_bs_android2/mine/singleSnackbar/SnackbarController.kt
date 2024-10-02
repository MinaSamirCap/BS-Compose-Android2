package com.sample.compose_bs_android2.mine.singleSnackbar

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

data class SnackbarEvent(
    val message: String,
    val action: SnackbarAction? = null
)

data class SnackbarAction(
    val name: String,
    val action: () -> Unit
)

object SnackbarController {

    /// Channel is a stream between our class and the subscriber.
    /// Channel behavior is very similar to shared flow except that
    /// Channel is meant to have one subscriber.
    /// Also, as we want to have one snackbar per system and one unit control.
    /// So, the channel will buffer the events by default so even if there is no active
    /// subscribers ... and send the event once we have the subscriber again ...
    private val _events = Channel<SnackbarEvent>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event: SnackbarEvent) {
        _events.send(event)
    }
}