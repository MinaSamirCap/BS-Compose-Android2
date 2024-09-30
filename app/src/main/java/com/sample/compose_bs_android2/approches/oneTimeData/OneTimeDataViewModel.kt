package com.sample.compose_bs_android2.approches.oneTimeData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OneTimeDataViewModel : ViewModel() {

    /// Third try ... the correct solution ...
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading
        .onStart {
            /// onStart is an flow operator that will be called when
            /// starting to collect the flow.
            loadData()
        }.stateIn(
            /// we used stateIn operator to convert the flow to hot flow
            /// as the start operator return flow and we need it to be a hot flow or state flow
            /// so multiple collectors will only get the cashed value or the most recent value.
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            /// The WhileSubscribed will keep cashing the result of the flow for a duration if
            /// there is no more collectors.
            /// in our case it will keep the flow for extra 5 seconds after the last collector
            /// disappeared.
            /// The recreate of an activity definitely is less than 5 seconds. So, the function
            /// loadData will not be called again ...
            false
        )


    /// Second try ...
    /// Also it is a good approach but
    /// We lose control when actually we load data
    /// Means once the view model created, it will load the data ...

    /*init {
        loadData()
    }*/

    fun loadData() {
        println("Loading data...")
        viewModelScope.launch {
            _isLoading.value = true
            delay(3000L)
            _isLoading.value = false
        }
    }

}