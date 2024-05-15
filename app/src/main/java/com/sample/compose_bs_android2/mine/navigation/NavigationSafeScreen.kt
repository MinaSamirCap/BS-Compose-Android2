package com.sample.compose_bs_android2.mine.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun NavigationSafeScreen(modifier: Modifier = Modifier) {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenA) {
        composable<ScreenA> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    // navigate to screenB
                    navController.navigate(ScreenB("Phillip", 20))
                }) {
                    Text(text = "Go to screen B")
                }
            }
        }

        composable<ScreenB> {

            val args = it.toRoute<ScreenB>()
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Name: ${args.name}, Age: ${args.age}")
            }
        }
    }
}


@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)

@Preview
@Composable
private fun NavigationSafeScreenPreview() {
    NavigationSafeScreen()
}

/// references
// https://www.youtube.com/watch?v=AIC_OFQ1r3k