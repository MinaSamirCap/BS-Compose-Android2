package com.sample.compose_bs_android2

import android.app.Application
import com.sample.compose_bs_android2.tasks.task1Articles.di.networkModule
import com.sample.compose_bs_android2.tasks.task1Articles.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(
                networkModule,
                viewModelModule
            )
        }
    }
}