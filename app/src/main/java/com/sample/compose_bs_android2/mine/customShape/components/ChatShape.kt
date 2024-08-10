package com.sample.compose_bs_android2.mine.customShape.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.mine.customShape.ChatBubbleShape

@Composable
fun ChatShape(text: String, size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(200.dp)
            .clip(ChatBubbleShape(tipSize = size, cornerRadius = size))
            .background(Color.Green)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .offset(x = size)
                .padding(5.dp)
        )
    }


}

@Preview
@Composable
private fun ChatShapePreview() {
    ChatShape("any text", size = 15.dp)
}