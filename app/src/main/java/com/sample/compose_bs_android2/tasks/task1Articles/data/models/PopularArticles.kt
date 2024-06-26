package com.sample.compose_bs_android2.tasks.task1Articles.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularArticles(
    @Json(name = "status")
    val status: String?,
    @Json(name = "copyright")
    val copyright: String?,
    @Json(name = "num_results")
    val numResults: Int?,
    @Json(name = "results")
    val results: List<ArticleApiModel?>?
)