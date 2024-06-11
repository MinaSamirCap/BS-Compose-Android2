package com.sample.compose_bs_android2.mine.solid

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SolidPrincipleScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "SolidPrinciple")
    }
}

@Preview
@Composable
private fun SolidPrincipleScreenPreview() {
    SolidPrincipleScreen()
}

/// references
// https://www.youtube.com/watch?v=t8VTLxMsufU