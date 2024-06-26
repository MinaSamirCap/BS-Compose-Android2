package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.img

import com.sample.compose_bs_android2.tasks.task1Articles.data.models.ArticleApiModel

fun imgArticleUrl(model: ArticleApiModel): String? {
    return try {
        model.media?.get(0)?.mediaMetadata?.get(2)?.url
    } catch (e: Exception) {
        null
    }
}