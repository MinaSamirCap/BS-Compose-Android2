package com.sample.compose_bs_android2.mine.previewMode.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.sample.compose_bs_android2.R

@Composable
fun ImageComponent(modifier: Modifier = Modifier) {
    val imageUrl = "https://img.goodfon.com/original/800x600/e/12/voda-more-aysberg-nebo.jpg"
    if (LocalInspectionMode.current) {
        // Show this image from the resources rather than loading an image from the internet
        Image(
            painter = painterResource(id = R.drawable.iceberg_preview),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        // Show this image in the live version
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun ImageComponentPreview() {
    ImageComponent()
}