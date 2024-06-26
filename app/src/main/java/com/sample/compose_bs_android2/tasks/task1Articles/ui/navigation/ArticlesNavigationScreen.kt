package com.sample.compose_bs_android2.tasks.task1Articles.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sample.compose_bs_android2.tasks.task1Articles.ui.articles.ArticlesScreen
import com.sample.compose_bs_android2.tasks.task1Articles.ui.components.img.imgArticleUrl
import com.sample.compose_bs_android2.tasks.task1Articles.ui.details.ArticleDetailsScreen

@Composable
fun ArticlesNavigationScreen(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ArticlesRoute.Home) {
        composable<ArticlesRoute.Home> {

            ArticlesScreen(
                onArticleClick = {
                    navController.navigate(
                        ArticlesRoute.ArticleDetails(
                            title = it.title,
                            by = it.byline,
                            publishedDate = it.publishedDate,
                            articleUrl = it.url,
                            imageUrl = imgArticleUrl(it)
                        )
                    )
                }
            )
        }

        composable<ArticlesRoute.ArticleDetails> {
            val args = it.toRoute<ArticlesRoute.ArticleDetails>()
            ArticleDetailsScreen(
                item = args,
                onCloseClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}

@Preview
@Composable
private fun ArticlesNavigationScreenPreview() {
    ArticlesNavigationScreen()
}

/// references
// type safe navigation with custom arguments
// https://medium.com/@edmiro/type-safety-in-navigation-compose-23c03e3d74a5