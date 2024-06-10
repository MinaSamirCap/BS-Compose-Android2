package com.sample.compose_bs_android2.tasks.task1Articles.di

import com.sample.compose_bs_android2.tasks.task1Articles.network.provideArticlesApi
import com.sample.compose_bs_android2.tasks.task1Articles.network.provideHttpLogger
import com.sample.compose_bs_android2.tasks.task1Articles.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    single { provideHttpLogger() }
    single { provideRetrofit(get()) }
    single { provideArticlesApi(get()) }
}