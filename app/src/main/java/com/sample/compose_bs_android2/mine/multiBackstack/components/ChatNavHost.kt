package com.sample.compose_bs_android2.mine.multiBackstack.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ChatNavHost(modifier: Modifier = Modifier) {
    val chatNavController = rememberNavController()

    NavHost(navController = chatNavController, startDestination = "chat1") {
        for (i in 1..10) {
            composable(route = "chat$i") {
                GenericScreen(text = "Chat $i", onNextClick = {
                    if (i < 10) {
                        chatNavController.navigate("chat${i + 1}")
                    }
                })
            }
        }
    }
}

@Preview
@Composable
private fun ChatNavHostPreview() {
    ChatNavHost()
}