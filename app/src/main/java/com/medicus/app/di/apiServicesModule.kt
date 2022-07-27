package com.medicus.app.di

import com.medicus.app.BuildConfig
import com.medicus.app.data.data_resource.remote_resource.api.APIServiceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiServicesModule = module {
    single {
        APIServiceProvider().provide(androidContext(), BuildConfig.API_BASE_URL)
    }
}
