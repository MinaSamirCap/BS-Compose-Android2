package com.sample.compose_bs_android2.tasks.task1Articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.compose_bs_android2.tasks.task1Articles.data.ArticlesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesApi: ArticlesApi
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    init {
        _title.value = "Press To Load"
    }

    suspend fun getArticles() {
        viewModelScope.launch {
            _title.value = "Loading..."
            val response = articlesApi.getArticles("30")
            _title.value = response.toString()
        }
    }
}