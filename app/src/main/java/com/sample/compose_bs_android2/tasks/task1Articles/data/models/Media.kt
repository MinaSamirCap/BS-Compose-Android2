package com.sample.compose_bs_android2.tasks.task1Articles.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "type")
    val type: String?,
    @Json(name = "subtype")
    val subtype: String?,
    @Json(name = "caption")
    val caption: String?,
    @Json(name = "copyright")
    val copyright: String?,
    @Json(name = "approved_for_syndication")
    val approvedForSyndication: Int?,
    @Json(name = "media-metadata")
    val mediaMetadata: List<MediaMetadata?>?
)