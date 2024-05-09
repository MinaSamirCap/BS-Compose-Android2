package com.sample.compose_bs_android2.mine.sharedElement

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailsScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope? = null,
    resId: Int,
    text: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .sharedElement(
                    state = rememberSharedContentState(key = "image/$resId"),
                    animatedVisibilityScope = animatedVisibilityScope!!,
                    boundsTransform = { _, _ ->
                        tween(durationMillis = 1000)
                    }
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = text,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .sharedElement(
                    state = rememberSharedContentState(key = "text/$text"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ ->
                        tween(durationMillis = 1000)
                    }
                ))
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
private fun DetailsScreenPreview() {
    SharedTransitionLayout {
        DetailsScreen(resId = R.drawable.kermit1, text = "Sample text")
    }
}