package com.sample.compose_bs_android2.mine.singleSnackbar.screenA

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarController
import com.sample.compose_bs_android2.mine.singleSnackbar.SnackbarEvent
import kotlinx.coroutines.launch

@Composable
fun SingleSnackbarScreenA(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModelA: SingleSnackbarViewModelA = viewModel()
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
                        message = "Hello World!"
                    )
                )
            }
        }) {
            Text("Show Snackbar")
        }

        Button(onClick = {
            viewModelA.showSnackbar()
        }) {
            Text("Show Snackbar by ViewModel")
        }

        Button(onClick = onNavigate) {
            Text("Navigate to screen")
        }

    }

}

@Preview
@Composable
private fun SingleSnackbarScreenAPreview() {
    SingleSnackbarScreenA(onNavigate = {

    })
}