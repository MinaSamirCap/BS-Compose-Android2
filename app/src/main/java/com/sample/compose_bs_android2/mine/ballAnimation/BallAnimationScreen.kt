package com.sample.compose_bs_android2.mine.ballAnimation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BallAnimationScreen(modifier: Modifier = Modifier) {


    var ballPosition by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    val bounceAnimation = rememberInfiniteTransition(label = "bounceAnimation")

    val yAnimation by bounceAnimation.animateFloat(
        initialValue = 0f,
        targetValue = 1200f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 400,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "yAnimation"
    )

    ballPosition = Offset(ballPosition.x, yAnimation)




    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(50.dp)) {
            drawCircle(
                color = Color.Blue,
                radius = 100f,
                center = ballPosition
            )
        }
    }
}

@Preview
@Composable
private fun BallAnimationScreenPreview() {
    BallAnimationScreen()
}

/// references
// https://www.youtube.com/shorts/izTE2IDR3WA