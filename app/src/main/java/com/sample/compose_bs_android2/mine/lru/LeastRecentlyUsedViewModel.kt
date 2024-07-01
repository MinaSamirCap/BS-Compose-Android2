package com.sample.compose_bs_android2.mine.lru

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeastRecentlyUsedViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _data = MutableStateFlow(listOf<String>())
    val data = _data.asStateFlow()


    init {
        MyCache.info()
        viewModelScope.launch {
            displayData()
            MyCache.info()
        }
    }

    private suspend fun displayData() {
        _isLoading.value = true
        val list: List<String>? = MyCache.getValues()
        if (list == null) {
            delay(2000)
            val newList = listOf("1", "2", "3", "4", "5", "6")
            MyCache.saveValues(newList)
            _data.value = newList
        } else {
            _data.value = list
        }
        _isLoading.value = false
    }
}