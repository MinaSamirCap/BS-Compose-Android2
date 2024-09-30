package com.sample.compose_bs_android2.approches.oneTimeData

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun OneTimeDataScreen(
    modifier: Modifier = Modifier,
    viewModel: OneTimeDataViewModel = viewModel()
) {

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    /// First try
    /// launch effect will help us to load if only one time...
    /// but if we rotated the device, changed them or app language ...
    /// ... the activity will be killed
    /// and app will enter new composition and launch effect
    /// will be called again

    /*LaunchedEffect(key1 = true) {
        viewModel.loadData()
    }*/
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = "OneTimeData LOADED")
        }
    }
}

@Preview
@Composable
private fun OneTimeDataScreenPreview() {
    OneTimeDataScreen()
}

/// references
// https://www.youtube.com/watch?v=mNKQ9dc1knI
// https://proandroiddev.com/loading-initial-data-in-launchedeffect-vs-viewmodel-f1747c20ce62