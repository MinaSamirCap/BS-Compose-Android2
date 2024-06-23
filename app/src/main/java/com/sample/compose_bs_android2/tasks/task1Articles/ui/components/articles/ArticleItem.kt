package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.articles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.Result
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.img.ArticleImg

@Composable
fun ArticleItem(
    item: Result,
    modifier: Modifier = Modifier,
    onItemClick: ((Result) -> Unit)? = null,
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(16.dp))
        .background(Color.LightGray)
        .clickable {
            onItemClick?.invoke(item)
        }) {

        ArticleImg(url = item.media?.get(0)?.mediaMetadata?.get(2)?.url)

        Text(
            text = item.title!!,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(all = 6.dp)
        )
    }
}

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