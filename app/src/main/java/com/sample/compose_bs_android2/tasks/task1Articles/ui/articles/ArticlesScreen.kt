package com.sample.compose_bs_android2.tasks.task1Articles.ui.articles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.ArticleApiModel
import com.sample.compose_bs_android2.tasks.task1Articles.network.provideArticlesApi
import com.sample.compose_bs_android2.tasks.task1Articles.network.provideHttpLogger
import com.sample.compose_bs_android2.tasks.task1Articles.network.provideRetrofit
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.articles.ArticlesLazyColumn
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.TimeGroup
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArticlesScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticlesViewModel = koinViewModel(),
    onArticleClick: ((ArticleApiModel) -> Unit)? = null
) {
    val loading = viewModel.loading.collectAsStateWithLifecycle()
    val error = viewModel.error.collectAsStateWithLifecycle()
    val response = viewModel.response.collectAsStateWithLifecycle()
    val filters = viewModel.filters.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TimeGroup(filters.value, timeSelected = {
            viewModel.onFilterClick(it)
        })

        if (loading.value.isNotEmpty()) {
            Text(text = loading.value)
        }

        if (error.value) {
            Text(text = "Error")
        }

        if (response.value.results != null && !error.value) {
            ArticlesLazyColumn(
                items = response.value.results!! as List<ArticleApiModel>,
                onItemClick = {
                    onArticleClick?.invoke(it)
                })
        }
    }
}

@Preview
@Composable
private fun ArticlesScreenPreview() {
    ArticlesScreen(
        viewModel = ArticlesViewModel(provideArticlesApi(provideRetrofit(provideHttpLogger())))
    )
}
/// references

/// MVI:
// https://medium.com/@alexzaitsev/mvi-with-android-compose-on-a-real-example-f5d522707be5
// https://medium.com/huawei-developers/mvi-architecture-with-jetpack-compose-8a59fff69624
// https://medium.com/@meetjanani47/mvi-architecture-implementation-with-kotlin-flow-android-ae094fa83bff
// https://github.com/myofficework000/MVI-JetpackCompose-Github

///