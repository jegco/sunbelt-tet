package com.example.sunbelttest.conf

import com.example.persistence.conf.BuildConf
import com.example.persistence.conf.RepositoryModule
import com.example.persistence.conf.RoomModule
import com.example.persistence.conf.ServicesModule
import com.example.sunbelttest.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ServicesModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    RoomModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideBaseConfig(): BuildConf = BuildConf(BuildConfig.SERVER_URL, BuildConfig.API_KEY)
}