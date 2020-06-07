package com.thebotbox.letsmvvm

import android.app.Application
import com.thebotbox.letsmvvm.di.koinNetworkModule
import com.thebotbox.letsmvvm.di.koinViewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    koinNetworkModule,
                    koinViewModels
                )
            )
        }
    }
}