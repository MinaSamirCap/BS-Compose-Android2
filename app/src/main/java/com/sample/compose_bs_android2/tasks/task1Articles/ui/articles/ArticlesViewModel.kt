package com.sample.compose_bs_android2.tasks.task1Articles.ui.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.compose_bs_android2.tasks.task1Articles.data.ArticlesApi
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.PopularArticles
import com.sample.compose_bs_android2.tasks.task1Articles.data.models.Result
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.TimeUiModel
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.lastDay
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.lastMonth
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.lastWeek
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time.timeUiModels
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesApi: ArticlesApi
) : ViewModel() {

    private val _loading = MutableStateFlow("")
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()

    private val _filters = MutableStateFlow(timeUiModels)
    val filters = _filters.asStateFlow()

    private val _response =
        MutableStateFlow(PopularArticles(null, null, null, null))
    val response = _response.asStateFlow()


    init {
        onFilterClick(_filters.value[0])
    }

    private fun getArticles() {
        viewModelScope.launch {
            try {
                _loading.value = "Loading..."
                val response = articlesApi.getArticles(getSelectedPeriod())
                _response.value = response
                _loading.value = ""
            } catch (e: Exception) {
                _loading.value = ""
                _error.value = true
            }

        }
    }

    fun onFilterClick(filter: TimeUiModel) {
        val list = _filters.value.map {
            it.copy(isSelected = false)
        }
        list.forEach {
            if (it.title == filter.title) {
                it.isSelected = true
            }
        }
        _filters.value = list
        getArticles()
    }

    fun onArticleClick(item: Result) {

    }

    private fun getSelectedPeriod(): String {
        val selectedFilter = _filters.value.first { it.isSelected }
        return when (selectedFilter.title) {
            lastDay -> "1"
            lastWeek -> "7"
            lastMonth -> "30"
            else -> "1"
        }
    }
}