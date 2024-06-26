package com.sample.compose_bs_android2.mine.animation

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
import kotlinx.serialization.Serializable

@Composable
fun AnimationTypesScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Navigation.AnimationTypes
    ) {

        composable<Navigation.AnimationTypes> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Button(onClick = {
                    navController.navigate(Navigation.Visibility)
                }) {
                    Text(text = "Visibility Animation")
                }

                Button(onClick = {
                    navController.navigate(Navigation.Size)
                }) {
                    Text(text = "Size Animation")
                }

                Button(onClick = {
                    navController.navigate(Navigation.ComposeContent)
                }) {
                    Text(text = "Compose Content Animation")
                }

                Button(onClick = {
                    navController.navigate(Navigation.SingleValue)
                }) {
                    Text(text = "Single Value Animation")
                }

                Button(onClick = {
                    navController.navigate(Navigation.MultiValue)
                }) {
                    Text(text = "Multi Value Animation")
                }

                Button(onClick = {
                    navController.navigate(Navigation.Infinity)
                }) {
                    Text(text = "Infinity Animation")
                }

            }
        }

        composable<Navigation.Visibility> {
            VisibilityAnimationScreen()
        }

        composable<Navigation.Size> {
            SizeAnimationScreen()
        }

        composable<Navigation.ComposeContent> {
            ComposeContentAnimationScreen()
        }

        composable<Navigation.SingleValue> {
            SingleValueAnimationScreen()
        }
        composable<Navigation.MultiValue> {
            MultiValueAnimationScreen()
        }
        composable<Navigation.Infinity> {
            InfinityAnimationScreen()
        }
    }
}

private object Navigation {

    @Serializable
    object AnimationTypes

    @Serializable
    object Visibility

    @Serializable
    object Size

    @Serializable
    object ComposeContent

    @Serializable
    object SingleValue

    @Serializable
    object MultiValue

    @Serializable
    object Infinity
}

@Preview
@Composable
private fun AnimationTypesScreenPreview() {
    AnimationTypesScreen()
}

/// references
// https://www.youtube.com/watch?v=wLmVyXl4Now
// https://developer.android.com/develop/ui/compose/animation/introduction