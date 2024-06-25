package com.sample.compose_bs_android2.mine.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VisibilityAnimationScreen(modifier: Modifier = Modifier) {

    var isContentVisible by remember { mutableStateOf(true) }
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { isContentVisible = !isContentVisible }) {
            Text(text = "Show/ Hide")
        }

        Spacer(modifier = Modifier.height(10.dp))

        AnimatedVisibility(
            visible = isContentVisible,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Cyan)
            )
        }

    }
}

@Preview
@Composable
private fun VisibilityAnimationScreenPreview() {
    VisibilityAnimationScreen()
}

/// references
// https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility