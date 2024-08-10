package com.sample.compose_bs_android2.mine.customShape

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.mine.customShape.components.ChatShape

@Composable
fun CustomShapeScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        ChatShape(text = "Mina Samir Sadik Khalil Ibrahim ", 15.dp)
        ChatShape(text = "Mina Samir Sadik Khalil Ibrahim ", 20.dp)
        ChatShape(text = "Mina Samir Sadik Khalil Ibrahim ", 36.dp)
    }
}

@Preview
@Composable
private fun CustomShapeScreenPreview() {
    CustomShapeScreen()
}

/// references
// https://www.youtube.com/watch?v=LEuxvDVA9pA