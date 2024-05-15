package com.sample.compose_bs_android2.mine.shortcuts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShortcutsScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Shortcuts")
    }
}

@Preview
@Composable
private fun ShortcutsScreenPreview() {
    ShortcutsScreen()
}

/// references
// https://www.youtube.com/watch?v=nXy1Zhf54fg