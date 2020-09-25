package com.example.sunbelttest.conf

import com.example.sunbelttest.MainActivity
import com.example.sunbelttest.splash.SplashActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun mainActivity(): MainActivity?

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun splashActivity(): SplashActivity?
}