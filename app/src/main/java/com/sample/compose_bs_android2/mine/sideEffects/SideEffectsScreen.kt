package com.sample.compose_bs_android2.mine.sideEffects

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

@Composable
fun SideEffectsScreen(modifier: Modifier = Modifier) {

    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = SideEffectsRouts.Home) {

        composable<SideEffectsRouts.Home> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Button(onClick = {
                    navigationController.navigate(SideEffectsRouts.LaunchedEffect)
                }) {
                    Text(text = "LaunchedEffect")
                }

                Button(onClick = {
                    navigationController.navigate(SideEffectsRouts.CoroutineScope)
                }) {
                    Text(text = "CoroutineScope")
                }

            }
        }


        composable<SideEffectsRouts.LaunchedEffect> {
            LaunchedEffectScreen()
        }

        composable<SideEffectsRouts.CoroutineScope> {
            CoroutineScopeScreen()
        }

    }
}

@Preview
@Composable
private fun SideEffectsScreenPreview() {
    SideEffectsScreen()
}

/// references
// https://www.youtube.com/watch?v=mGpax3Y5B7E
// https://developer.android.com/develop/ui/compose/side-effects