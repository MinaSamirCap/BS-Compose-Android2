package com.sample.compose_bs_android2.mine.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ComposeContentAnimationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var count by remember {
            mutableIntStateOf(0)
        }

        Button(onClick = {
            count++
        }) {
            Text(text = "Click me")
        }

        Spacer(modifier = Modifier.height(10.dp))

        AnimatedContent(targetState = count, label = "",
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }) {
            Text(text = "Count: $it")
        }
    }
}

@Preview
@Composable
private fun ComposeContentAnimationScreenPreview() {
    ComposeContentAnimationScreen()
}