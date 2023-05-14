package br.com.githubusers

import android.app.Application
import br.com.githubusers.di.networkModule
import br.com.githubusers.di.useCaseModule
import br.com.githubusers.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(listOf(networkModule, useCaseModule, viewModelModule))
        }
    }
}