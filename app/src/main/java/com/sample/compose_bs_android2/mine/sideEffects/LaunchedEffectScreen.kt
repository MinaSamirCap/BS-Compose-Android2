package com.sample.compose_bs_android2.mine.sideEffects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun LaunchedEffectScreen(modifier: Modifier = Modifier) {

    val maxNumber = 10

    var counter by remember {
        mutableIntStateOf(0)
    }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text(text = "Counter should reach to $maxNumber\nCurrently is $counter")
        Counter(max = maxNumber, onCountChange = {
            counter = it
        })
    }
}


@Composable
private fun Counter(
    max: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    var counter by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = counter) {
        if (counter >= max + 1) {
            return@LaunchedEffect
        }

        delay(1.seconds)
        onCountChange(counter)
        counter++
    }

}


@Preview
@Composable
private fun LaunchedEffectScreenPreview() {
    LaunchedEffectScreen()
}
