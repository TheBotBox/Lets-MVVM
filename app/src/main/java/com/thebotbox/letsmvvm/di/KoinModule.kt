package com.thebotbox.letsmvvm.di


import com.thebotbox.letsmvvm.data.db.QuoteDB
import com.thebotbox.letsmvvm.data.db.dao.QuoteDao
import com.thebotbox.letsmvvm.data.network.factory.ApiClientFactory
import com.thebotbox.letsmvvm.data.network.factory.IApiFactory
import com.thebotbox.letsmvvm.data.network.interceptor.NetworkConnectionInterceptor
import com.thebotbox.letsmvvm.data.repository.IRepository
import com.thebotbox.letsmvvm.data.repository.Repository
import com.thebotbox.letsmvvm.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val koinNetworkModule = module(override = true) {
    single { NetworkConnectionInterceptor(androidContext()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single(named("secondInstance")) { provideRetrofitSecondInstance(get()) }

    single<IApiFactory> { ApiClientFactory(get(), get()) }
    single<QuoteDao> { QuoteDB(androidContext()).dao() }

    single<IRepository> { Repository(get(), get()) }
}

val koinViewModels = module {
    viewModel { MainViewModel(get()) }
}