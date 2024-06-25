package com.sample.compose_bs_android2.mine.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MultiValueAnimationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val scope = rememberCoroutineScope()

        // we are using Animatable if we want to do multi animation
        // at the same time using coroutine.
        val scale = remember {
            Animatable(initialValue = 1f)
        }
        val alpha = remember {
            Animatable(initialValue = 1f)
        }

        var color by remember {
            mutableStateOf(Color.Blue)
        }

        val animatedColor by animateColorAsState(
            targetValue = color, label = "",
            animationSpec = tween(durationMillis = 1000)
        )

        Box(modifier = Modifier
            .size(100.dp)
            .scale(scale.value)
            .clip(CircleShape)
            .background(animatedColor.copy(alpha = alpha.value))
            .clickable {
                scope.launch {

                    // each launch block will run together ...
                    launch {
                        scale.animateTo(
                            targetValue = scale.value + 0.5f,
                            animationSpec = tween(durationMillis = 1000)
                        )
                    }
                    launch {
                        if (alpha.value != 0.1f) {
                            alpha.animateTo(
                                targetValue = alpha.value - 0.1f,
                                animationSpec = tween(durationMillis = 1000)
                            )
                        }
                    }
                }
                color = Color(
                    red = (0..255).random(),
                    green = (0..255).random(),
                    blue = (0..255).random()
                )
            })
    }
}

@Preview
@Composable
private fun MultiValueAnimationScreenPreview() {
    MultiValueAnimationScreen()
}