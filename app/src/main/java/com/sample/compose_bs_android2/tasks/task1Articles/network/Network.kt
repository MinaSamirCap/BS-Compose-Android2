package com.sample.compose_bs_android2.tasks.task1Articles.network


import com.sample.compose_bs_android2.tasks.task1Articles.data.ArticlesApi
import com.sample.compose_bs_android2.tasks.task1Articles.data.Endpoints
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object SingleMoshi {
    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}

fun provideHttpLogger(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor;
}

fun provideRetrofit(
    httpLoggingInterceptor: HttpLoggingInterceptor
): Retrofit {
    val client = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
    return Retrofit.Builder()
        .baseUrl(Endpoints.BASE_URL) // should used from BuildConfig
        .addConverterFactory(MoshiConverterFactory.create(SingleMoshi.moshi))
        .client(client)
        .build()
}

fun provideArticlesApi(
    retrofit: Retrofit
): ArticlesApi {
    return retrofit.create(ArticlesApi::class.java)
}