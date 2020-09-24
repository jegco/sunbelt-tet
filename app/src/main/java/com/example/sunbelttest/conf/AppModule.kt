package com.example.sunbelttest.conf

import android.app.Application
import android.content.Context
import com.example.persistence.conf.BuildConf
import com.example.sunbelttest.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideBaseConfig(): BuildConf = BuildConf(BuildConfig.SERVER_URL, BuildConfig.API_KEY)
}