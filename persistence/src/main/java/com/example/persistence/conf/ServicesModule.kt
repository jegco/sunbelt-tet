package com.example.persistence.conf

import com.example.persistence.services.MoviesService
import com.example.persistence.services.interceptors.ApiCallInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServicesModule {

    @Provides
    @Singleton
    fun provideApiCallInterceptor(buildConf: BuildConf): ApiCallInterceptor =
        ApiCallInterceptor(buildConf.apiKey)

    @Provides
    fun providesClient(apiCallInterceptor: ApiCallInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.NONE
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor(apiCallInterceptor)
            .build()
    }

    @Provides
    fun providesRetrofit(buildConf: BuildConf, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(buildConf.baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()

    @Provides
    @Singleton
    fun providesMoviesCollectionService(retrofit: Retrofit): MoviesService =
        retrofit
            .create(MoviesService::class.java)
}