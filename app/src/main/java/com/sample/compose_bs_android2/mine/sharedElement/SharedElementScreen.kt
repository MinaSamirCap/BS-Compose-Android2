package com.sample.compose_bs_android2.mine.sharedElement

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedElementScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()) {


        SharedTransitionLayout {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "list"
            ) {

                composable("list") {
                    ListScreen(
                        animatedVisibilityScope = this,
                        onItemClick = { resId, text ->
                            navController.navigate("detail/$resId/$text")
                        }
                    )
                }

                composable(route = "detail/{resId}/{text}", arguments = listOf(
                    navArgument("resId") { type = NavType.IntType },
                    navArgument("text") { type = NavType.StringType }
                )) { backStackEntry ->
                    val resId = backStackEntry.arguments?.getInt("resId")!!
                    val text = backStackEntry.arguments?.getString("text")!!


                    DetailsScreen(animatedVisibilityScope = this, resId = resId, text = text)

                }

            }
        }
    }
}

@Preview
@Composable
private fun SharedElementScreenPreview() {
    SharedElementScreen()
}


/// references ...
// https://www.youtube.com/watch?v=mE5bLb42_Os