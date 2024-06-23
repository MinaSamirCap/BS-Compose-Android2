package com.sample.compose_bs_android2.tasks.task1Articles.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "uri")
    val uri: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "id")
    val id: Long?,
    @Json(name = "asset_id")
    val assetId: Long?,
    @Json(name = "source")
    val source: String?,
    @Json(name = "published_date")
    val publishedDate: String?,
    @Json(name = "updated")
    val updated: String?,
    @Json(name = "section")
    val section: String?,
    @Json(name = "subsection")
    val subsection: String?,
    @Json(name = "nytdsection")
    val nytdsection: String?,
    @Json(name = "adx_keywords")
    val adxKeywords: String?,
    @Json(name = "column")
    val column: Any?,
    @Json(name = "byline")
    val byline: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "abstract")
    val `abstract`: String?,
    @Json(name = "des_facet")
    val desFacet: List<String?>?,
    @Json(name = "org_facet")
    val orgFacet: List<String?>?,
    @Json(name = "per_facet")
    val perFacet: List<String?>?,
    @Json(name = "geo_facet")
    val geoFacet: List<String?>?,
    @Json(name = "media")
    val media: List<Media?>?,
    @Json(name = "eta_id")
    val etaId: Int?
)


val dummyArticleItem = Result(
    title = "This is the title of article",
    id = null,
    media = null,
    publishedDate = null,
    type = null,
    url = "https://www.google.com",
    byline = null,
    abstract = null,
    section = null,
    subsection = null,
    source = null,
    uri = null,
    etaId = null,
    column = null,
    desFacet = null,
    geoFacet = null,
    orgFacet = null,
    perFacet = null,
    assetId = null,
    updated = null,
    adxKeywords = null,
    nytdsection = null
)