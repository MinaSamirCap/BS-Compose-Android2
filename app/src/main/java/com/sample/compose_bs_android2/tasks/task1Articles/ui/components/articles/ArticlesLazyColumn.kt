package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.articles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.ArticleApiModel
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.dummyArticleItem

@Composable
fun ArticlesLazyColumn(
    items: List<ArticleApiModel>,
    modifier: Modifier = Modifier,
    onItemClick: ((ArticleApiModel) -> Unit)? = null
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(items,
            key = { index, _ ->
                index.toString()
            }, itemContent = { _, item ->
                ArticleItem(
                    item = item,
                    onItemClick = onItemClick
                )
            })
    }
}

@Preview
@Composable
private fun ArticlesLazyColumnPreview() {
    ArticlesLazyColumn(
        items = listOf(
            dummyArticleItem,
            dummyArticleItem,
            dummyArticleItem,
            dummyArticleItem,
            dummyArticleItem,
            dummyArticleItem,
        )
    )
}