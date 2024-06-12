package com.sample.compose_bs_android2.tasks.task1Articles.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.compose_bs_android2.R
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.Result

@Composable
fun ArticleItem(
    item: Result,
    modifier: Modifier = Modifier,
    onItemClick: ((Result) -> Unit)? = null,
) {
    val isPreviewMode = LocalInspectionMode.current

    Column(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(16.dp))
        .background(Color.LightGray)
        .clickable {
            onItemClick?.invoke(item)
        }) {
        if (isPreviewMode) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.kermit1),
                contentDescription = null
            )
        } else {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                contentScale = ContentScale.Crop,
                model = item.media?.get(0)?.mediaMetadata?.get(2)?.url
                    ?: noImageFoundUrl, contentDescription = null
            )
        }
        Text(
            text = item.title!!,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(all = 6.dp)
        )
    }
}


private const val noImageFoundUrl =
    "https://consultix.radiantthemes.com/demo-nine/wp-content/themes/consultix/images/no-image-found-360x250.png"

@Preview
@Composable
private fun ArticleItemPreview() {
    ArticleItem(
        Result(
            title = "This is the title of article",
            id = null,
            media = null,
            publishedDate = null,
            type = null,
            url = null,
            byline = null,
            abstract = null,
            section = null,
            subsection = null,
            source = null,
            uri = null,
            etaId = null,
            column = null,
            desFacet = null,
            geoFacet = null,
            orgFacet = null,
            perFacet = null,
            assetId = null,
            updated = null,
            adxKeywords = null,
            nytdsection = null
        )
    )
}