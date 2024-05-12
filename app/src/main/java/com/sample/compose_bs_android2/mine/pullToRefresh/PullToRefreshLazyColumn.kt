package com.sample.compose_bs_android2.mine.pullToRefresh

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> PullToRefreshLazyColumn(
    items: List<T>,
    content: @Composable (T) -> Unit,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState(), // if we want to pass a state for the lazy column
) {

    val pullRefreshState = rememberPullToRefreshState()

    // we need to add the lazy column to any container to connect the container
    // to the pull refresh state by using modifier.nestedScroll
    // So, when I swipe down the pull to refresh indicator appears.
    Box(modifier = modifier.nestedScroll(pullRefreshState.nestedScrollConnection)) {

        LazyColumn(
            state = lazyListState,
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(items) {
                content(it)
            }
        }

        // we need to fire onRefresh once at a time when pullRefreshState.isRefreshing changed
        // to notify about the actual refreshing
        if (pullRefreshState.isRefreshing) {
            LaunchedEffect(key1 = true) {
                // actual refreshing ...
                onRefresh()
            }
        }

        // to control the refreshing from outside the composable ...
        LaunchedEffect(key1 = isRefreshing) {
            if (isRefreshing) {
                pullRefreshState.startRefresh()
            } else {
                pullRefreshState.endRefresh()
            }
        }

        // connect the pull refresh state to the pull to refresh container ...
        // to see the pull to refresh indicator on the screen
        PullToRefreshContainer(
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }

}