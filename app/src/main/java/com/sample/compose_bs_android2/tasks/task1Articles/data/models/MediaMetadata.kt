package com.sample.compose_bs_android2.tasks.task1Articles.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MediaMetadata(
    @Json(name = "url")
    val url: String?,
    @Json(name = "format")
    val format: String?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "width")
    val width: Int?
)