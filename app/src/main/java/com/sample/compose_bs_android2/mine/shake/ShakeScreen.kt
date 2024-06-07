package com.sample.compose_bs_android2.mine.shake

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun ShakeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val shakeState = rememberShakingState(
            directions = ShakingState.Directions.LEFT_THEN_RIGHT
        )
        val scope = rememberCoroutineScope()
        Text(text = "Shake",
            modifier
                .clickable {
                    scope.launch {
                        shakeState.shake()
                    }
                }
                .shakable(shakeState)
        )
    }
}

@Preview
@Composable
private fun ShakeScreenPreview() {
    ShakeScreen()
}

/// references
// https://www.youtube.com/watch?v=e20DAyE0YsY