package com.sample.compose_bs_android2.tasks.task1Articles.data

import com.sample.compose_bs_android2.tasks.task1Articles.data.models.PopularArticles
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticlesApi {
    @GET(Endpoints.MOST_POPULAR)
    suspend fun getArticles(@Path(Endpoints.PERIOD_KEY) period: String): PopularArticles
}
