package br.com.githubusers.di

import br.com.datalayer.api.UserService
import br.com.datalayer.datasource.UserDataSource
import br.com.datalayer.datasource.UserDataSourceImpl
import br.com.datalayer.repository.UserRepositoryImpl
import br.com.domain.repository.UserRepository
import br.com.githubusers.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideRetrofitClient() }
    single {
        get<Retrofit>().create(UserService::class.java)
    }
    single<UserDataSource> {
        UserDataSourceImpl(get())
    }
    single<UserRepository> {
        UserRepositoryImpl(get(), provideIoDispatcher())
    }
}

fun provideRetrofitClient() =
    retrofitClient(okHttpClient())

private fun okHttpClient() =
    OkHttpClient.Builder().run {
        addInterceptor(HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            readTimeout(60L, TimeUnit.SECONDS)
            connectTimeout(60L, TimeUnit.SECONDS)
            writeTimeout(60L, TimeUnit.SECONDS)
        })
        build()
    }

private fun retrofitClient(httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().run {
        baseUrl(BuildConfig.BASE_URL)
        client(httpClient)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }

fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
