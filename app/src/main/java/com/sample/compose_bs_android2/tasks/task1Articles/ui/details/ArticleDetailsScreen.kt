package com.sample.compose_bs_android2.tasks.task1Articles.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.img.ArticleImg
import com.sample.compose_bs_android2.tasks.task1Articles.ui.navigation.ArticlesRoute
import com.sample.compose_bs_android2.utils.IntentUtil

@Composable
fun ArticleDetailsScreen(
    item: ArticlesRoute.ArticleDetails,
    modifier: Modifier = Modifier,
    onCloseClick: (() -> Unit)? = null
) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(onClick = {
            onCloseClick?.invoke()
        }) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "close"
            )
        }

        ArticleImg(url = item.imageUrl)

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = item.title!!,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = item.by ?: "No name provided")
        Text(text = "Published ${item.publishedDate}")

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    IntentUtil.openBrowser(context, item.articleUrl)
                }
                .background(color = MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                contentDescription = "OpenBrowser"
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = "Open in Browser")
        }

    }
}

@Preview
@Composable
private fun ArticleDetailsScreenPreview() {
    ArticleDetailsScreen(
        ArticlesRoute.ArticleDetails(
            title = "This is the title of article",
            by = "Mina Samir",
            publishedDate = "2 days ago",
            imageUrl = null,
            articleUrl = "https://www.google.com"
        )
    )
}