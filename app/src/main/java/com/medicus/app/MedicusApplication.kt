package com.medicus.app
import android.app.Application
import com.medicus.app.di.apiServicesModule
import com.medicus.app.di.repoModule
import com.medicus.app.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MedicusApplication : Application() {

    val LOG_TAG = "MarvelApplication"

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MedicusApplication)
            modules(apiServicesModule, repoModule, viewModelsModule)
        }
    }
}