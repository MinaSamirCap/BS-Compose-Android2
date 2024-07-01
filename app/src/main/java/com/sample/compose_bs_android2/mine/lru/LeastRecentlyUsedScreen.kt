package com.sample.compose_bs_android2.mine.lru

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Composable
fun LeastRecentlyUsedScreen(
    modifier: Modifier = Modifier
) {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LRUScreen1) {
        composable<LRUScreen1> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    navController.navigate(LRUScreen2)
                }) {
                    Text(text = "Go Next")
                }
            }
        }

        composable<LRUScreen2> {

            val viewModel: LeastRecentlyUsedViewModel = viewModel()
            val isLoading = viewModel.isLoading.collectAsStateWithLifecycle().value
            val data = viewModel.data.collectAsStateWithLifecycle().value

            if (isLoading) {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            if (data.isNotEmpty()) {
                LazyColumn {
                    itemsIndexed(data) { _, it ->
                        Text(text = it, modifier = Modifier.padding(16.dp))
                    }
                }
            } else {
                if (!isLoading) {
                    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "NO DATA!")
                    }
                }
            }
        }
    }
}

@Serializable
object LRUScreen1

@Serializable
object LRUScreen2

@Preview
@Composable
private fun LeastRecentlyUsedScreenPreview() {
    LeastRecentlyUsedScreen()
}

/// references
// https://www.youtube.com/watch?v=tiGNgsTBp6Y