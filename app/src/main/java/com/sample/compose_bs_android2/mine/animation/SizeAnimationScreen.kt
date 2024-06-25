package com.sample.compose_bs_android2.mine.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun SizeAnimationScreen(modifier: Modifier = Modifier) {

    var isAllTxtVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = textToTest,
            modifier = Modifier
                .padding(10.dp)
                .background(Color.LightGray)
                .clickable {
                    isAllTxtVisible = !isAllTxtVisible
                }
                .animateContentSize(
                    // we can use spring or tween here
                    // for other clarification and visualizing of parameters
                    // please check the reference below...
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                ),
            maxLines = if (isAllTxtVisible) Int.MAX_VALUE else 2
        )

    }
}

private val textToTest = "This is the text that will be animated".repeat(20)

@Preview
@Composable
private fun SizeAnimationScreenPreview() {
    SizeAnimationScreen()
}

/// references
// https://developer.android.com/develop/ui/compose/animation/customize

/// What is tweening?
/// Tweening is the process of creating the inbetweens,
/// which are the images that go between keyframes.
/// Also known as 'inbetweeing,' the result in a smooth transition
/// between two keyframes that depict different points in an action.
/// Tweening is necessary to convey a sense of fluid movement with still images.
/// Inbetweens are typically considered less imperative than keyframes.
/// Lead artists draw keyframes while inbetweens are often handled by junior artists or assistants.
/// https://www.studiobinder.com/blog/what-is-tweening-in-animation/

/// What is spring?
/// A spring animation has this name because the animation itself follows
/// the physics of a spring or what we also call a Harmonic Oscillator.
/// This term and the math surrounding it might seem
/// very scary and complicated but bare with me,
/// I'll break down everything as simply as possible.
/// When I was in college, we defined a Harmonic Oscillator as follows
/// https://blog.maximeheckel.com/posts/the-physics-behind-spring-animations/
