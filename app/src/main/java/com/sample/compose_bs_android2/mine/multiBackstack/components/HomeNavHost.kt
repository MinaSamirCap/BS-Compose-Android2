package com.sample.compose_bs_android2.mine.multiBackstack.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavHost(modifier: Modifier = Modifier) {
    val homeNavController = rememberNavController()

    NavHost(navController = homeNavController, startDestination = "home1") {
        for (i in 1..10) {
            composable(route = "home$i") {
                GenericScreen(text = "Home $i", onNextClick = {
                    if (i < 10) {
                        homeNavController.navigate("home${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview
@Composable
private fun HomeNavHostPreview() {
    HomeNavHost()
}