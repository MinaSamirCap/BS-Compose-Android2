package com.sample.compose_bs_android2.tasks.task1Articles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun Task1ArticlesScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticlesViewModel = koinViewModel(),
) {

    val scope = rememberCoroutineScope()
    val title = viewModel.title.collectAsStateWithLifecycle()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            scope.launch {
                viewModel.getArticles()
            }
        }) {
            Text(text = "Get Articles")
        }
        Text(text = title.value)
    }
}

@Preview
@Composable
private fun Task1ArticlesScreenPreview() {
    Task1ArticlesScreen()
}

/// references

/// MVI:
// https://medium.com/@alexzaitsev/mvi-with-android-compose-on-a-real-example-f5d522707be5
// https://medium.com/huawei-developers/mvi-architecture-with-jetpack-compose-8a59fff69624
// https://medium.com/@meetjanani47/mvi-architecture-implementation-with-kotlin-flow-android-ae094fa83bff
// https://github.com/myofficework000/MVI-JetpackCompose-Github

///