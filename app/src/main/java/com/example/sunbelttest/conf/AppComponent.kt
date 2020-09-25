package com.example.sunbelttest.conf

import android.app.Application
import com.example.persistence.conf.RepositoryModule
import com.example.persistence.conf.RoomModule
import com.example.persistence.conf.ServicesModule
import com.example.sunbelttest.MainActivity
import com.example.sunbelttest.base.BaseFragment
import com.example.sunbelttest.moviedescription.MovieDetailsFragment
import com.example.sunbelttest.movielist.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ServicesModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        RoomModule::class]
)
interface AppComponent {

    fun inject(target: MainActivity)

    fun inject(target: MovieListFragment)

    fun inject(target: BaseFragment)

    fun inject(target: MovieDetailsFragment)
}