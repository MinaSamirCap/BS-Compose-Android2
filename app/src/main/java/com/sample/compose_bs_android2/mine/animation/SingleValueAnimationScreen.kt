package com.sample.compose_bs_android2.mine.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SingleValueAnimationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var scale by remember {
            mutableFloatStateOf(1f)
        }

        var color by remember {
            mutableStateOf(Color.Blue)
        }

        val animatedScale by animateFloatAsState(
            targetValue = scale, label = "",
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )

        val animatedColor by animateColorAsState(
            targetValue = color, label = "",
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )

        Box(modifier = Modifier
            .size(100.dp)
            .scale(animatedScale)
            .clip(CircleShape)
            .background(animatedColor)
            .clickable {
                scale += 0.3f
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
private fun SingleValueAnimationScreenPreview() {
    SingleValueAnimationScreen()
}