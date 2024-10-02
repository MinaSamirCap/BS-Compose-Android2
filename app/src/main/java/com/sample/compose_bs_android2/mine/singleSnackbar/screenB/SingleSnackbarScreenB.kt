package com.sample.compose_bs_android2.mine.singleSnackbar.screenB

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarController
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarEvent
import kotlinx.coroutines.launch

@Composable
fun SingleSnackbarScreenB(
    modifier: Modifier = Modifier
) {

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            coroutineScope.launch {
                SnackbarController.sendEvent(
                    event = SnackbarEvent(
                        message = "Hello from B!"
                    )
                )
            }
        }) {
            Text("Show Snackbar")
        }
    }

}

@Preview
@Composable
private fun SingleSnackbarScreenBPreview() {
    SingleSnackbarScreenB()
}