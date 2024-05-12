package com.sample.compose_bs_android2.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TemplateScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Template")
    }
}

@Preview
@Composable
private fun TemplateScreenPreview() {
    TemplateScreen()
}

/// references
// https://www.youtube.com/watch?v=e20DAyE0YsY