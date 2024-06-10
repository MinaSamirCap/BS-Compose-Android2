package com.sample.compose_bs_android2.tasks.task1Articles.di

import com.sample.compose_bs_android2.tasks.task1Articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ArticlesViewModel(get()) }
}