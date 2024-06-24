package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.img

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.compose_bs_android2.R

@Composable
fun ArticleImg(
    url: String?,
    modifier: Modifier = Modifier
) {

    val isPreviewMode = LocalInspectionMode.current

    if (isPreviewMode) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.kermit1),
            contentDescription = null
        )
    } else {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop,
            model = if (url.isNullOrEmpty()) noImageFoundUrl else url, contentDescription = null
        )
    }
}

private const val noImageFoundUrl =
    "https://consultix.radiantthemes.com/demo-nine/wp-content/themes/consultix/images/no-image-found-360x250.png"


@Preview
@Composable
private fun ArticleImgPreview() {
    ArticleImg(url = "")
}