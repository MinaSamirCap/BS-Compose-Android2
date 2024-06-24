package com.sample.compose_bs_android2.tasks.task1Articles.ui.navigation

import kotlinx.serialization.Serializable

object ArticlesRoute {

    @Serializable
    object Home

    @Serializable
    data class ArticleDetails(
        val title: String?,
        val by: String?,
        val publishedDate: String?,
        val imageUrl: String?,
        val articleUrl: String?
    )

}



/// references
// type safe navigation with custom arguments
// https://medium.com/@edmiro/type-safety-in-navigation-compose-23c03e3d74a5