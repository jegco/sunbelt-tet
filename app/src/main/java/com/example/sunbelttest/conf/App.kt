package com.example.sunbelttest.conf

import android.app.Application
import com.example.persistence.conf.RepositoryModule
import com.example.persistence.conf.ServicesModule

class App: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .servicesModule(ServicesModule())
            .repositoryModule(RepositoryModule())
            .useCaseModule(UseCaseModule())
            .build()
    }
}