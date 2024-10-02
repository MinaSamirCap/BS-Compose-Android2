package com.sample.compose_bs_android2.mine.singleSnackbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SingleSnackbarScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "SingleSnackbar")
    }
}

@Preview
@Composable
private fun SingleSnackbarScreenPreview() {
    SingleSnackbarScreen()
}

/// references
// https://www.youtube.com/watch?v=KFazs62lIkE