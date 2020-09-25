package com.example.sunbelttest.conf

import com.example.sunbelttest.moviedescription.MovieDetailsFragment
import com.example.sunbelttest.movielist.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment?
    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailsFragment?
}