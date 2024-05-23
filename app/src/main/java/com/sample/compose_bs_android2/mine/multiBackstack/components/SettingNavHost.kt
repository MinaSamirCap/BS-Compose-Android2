package com.sample.compose_bs_android2.mine.multiBackstack.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsNavHost(modifier: Modifier = Modifier) {
    val settingsNavController = rememberNavController()

    NavHost(navController = settingsNavController, startDestination = "settings1") {
        for (i in 1..10) {
            composable(route = "settings$i") {
                GenericScreen(text = "Settings $i", onNextClick = {
                    if (i < 10) {
                        settingsNavController.navigate("settings${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview
@Composable
private fun SettingsNavHostPreview() {
    SettingsNavHost()
}