package com.jda.blockbuster.di

import com.jda.blockbuster.data.repository.MovieRepositoryImpl
import com.jda.blockbuster.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindMoviesRepository(impl: MovieRepositoryImpl): MoviesRepository
}