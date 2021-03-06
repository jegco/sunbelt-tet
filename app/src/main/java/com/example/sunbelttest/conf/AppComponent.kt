package com.example.sunbelttest.conf

import android.app.Application
import com.example.persistence.conf.RepositoryModule
import com.example.persistence.conf.RoomModule
import com.example.persistence.conf.ServicesModule
import com.example.sunbelttest.MainActivity
import com.example.sunbelttest.moviedescription.MovieDetailsFragment
import com.example.sunbelttest.movielist.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    fun inject(target: MainActivity)

    fun inject(target: MovieListFragment)

    fun inject(target: MovieDetailsFragment)
}