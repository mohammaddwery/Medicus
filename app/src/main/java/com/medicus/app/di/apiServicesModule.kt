package com.medicus.app.di

import com.medicus.app.BuildConfig
import com.medicus.app.data.data_resource.remote_resource.api.HttpClientManager
import com.medicus.app.data.data_resource.remote_resource.api.biomarker.BiomarkerApiProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val apiServicesModule = module {
    single {
        HttpClientManager().provide(androidContext(), BuildConfig.API_BASE_URL)
    }
    single<BiomarkerApiProvider> {
        get<Retrofit>().create(BiomarkerApiProvider::class.java)
    }
}
