package com.sample.compose_bs_android2.tasks.task1Articles.data

object Endpoints {

    private const val API_KEY = "gYV1vX8TGrANE7gwAGmPnCoKSDDGF9GU"

    const val BASE_URL = "https://api.nytimes.com/"

    const val PERIOD_KEY = "period"
    const val MOST_POPULAR = "svc/mostpopular/v2/viewed/{$PERIOD_KEY}.json?api-key=$API_KEY"

}