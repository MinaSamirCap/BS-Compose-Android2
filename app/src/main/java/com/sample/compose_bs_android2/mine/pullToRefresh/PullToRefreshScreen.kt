package com.sample.compose_bs_android2.mine.pullToRefresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PullToRefreshScreen(modifier: Modifier = Modifier) {

    val items = remember {
        (1..100).map { "Item $it" }
    }

    var isRefreshing by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        PullToRefreshLazyColumn(
            items = items,
            isRefreshing = isRefreshing,
            content = {
                Text(text = it, modifier = Modifier.padding(16.dp))
            },
            onRefresh = {
                scope.launch {
                    isRefreshing = true
                    delay(3000L) // simulate API call ...
                    isRefreshing = false
                }
            }

        )

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding(),
            onClick = {
                isRefreshing = true
            }) {
            Text(text = "Refresh")
        }
    }

}

@Preview
@Composable
private fun PullToRefreshScreenPreview() {
    PullToRefreshScreen()
}

/// references
// https://www.youtube.com/watch?v=e20DAyE0YsY