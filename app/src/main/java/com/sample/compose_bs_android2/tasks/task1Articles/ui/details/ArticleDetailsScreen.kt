package com.sample.compose_bs_android2.tasks.task1Articles.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ArticleDetailsScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "ArticleDetails")
    }
}

@Preview
@Composable
private fun ArticleDetailsScreenPreview() {
    ArticleDetailsScreen()
}