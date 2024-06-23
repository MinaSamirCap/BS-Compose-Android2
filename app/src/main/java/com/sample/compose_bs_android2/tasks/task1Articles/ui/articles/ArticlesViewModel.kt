package com.sample.compose_bs_android2.tasks.task1Articles.ui.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.compose_bs_android2.tasks.task1Articles.data.ArticlesApi
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.PopularArticles
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesApi: ArticlesApi
) : ViewModel() {

    private val _loading = MutableStateFlow("")
    val loading = _loading.asStateFlow()

    private val _response =
        MutableStateFlow(PopularArticles(null, null, null, null))
    val response = _response.asStateFlow()

    suspend fun getArticles() {
        viewModelScope.launch {
            _loading.value = "Loading..."
            val response = articlesApi.getArticles("30")
            _response.value = response
            _loading.value = ""
        }
    }

    fun onArticleClick(item: Result) {

    }
}