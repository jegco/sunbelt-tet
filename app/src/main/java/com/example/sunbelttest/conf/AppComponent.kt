package com.example.sunbelttest.conf

import com.example.persistence.conf.RepositoryModule
import com.example.persistence.conf.ServicesModule
import com.example.sunbelttest.MainActivity
import com.example.sunbelttest.conf.AppModule
import com.example.sunbelttest.conf.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ServicesModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
}