package com.sample.compose_bs_android2.mine.mutex.simple

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
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Composable
fun SimpleMutexScreen(modifier: Modifier = Modifier) {
    val mutex = remember { Mutex() }

    var counter by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        repeat(10) {
            launch {
                mutex.withLock {
                    try {
                        delay(1000)
                        if (it == 0) throw IllegalArgumentException("Oops!")
                        counter++
                    } catch (e: Exception) {
                        println(e)
                    }
                }
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = counter.toString())
    }
}

@Preview
@Composable
private fun SimpleMutexScreenPreview() {
    SimpleMutexScreen()
}

/// references
// https://www.youtube.com/watch?v=RGtZXBm30RQ