package com.jda.blockbuster.data.repository

import com.jda.blockbuster.data.remote.MoviesApiService
import com.jda.blockbuster.domain.model.MovieD
import com.jda.blockbuster.domain.model.toDomainModel
import com.jda.blockbuster.domain.repository.MoviesRepository
import com.jda.blockbuster.ui.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApiService
) : MoviesRepository {
    override suspend fun fetchPopularMovies(): List<MovieD> =
        api.fetchPopularMovies("US").results.map { it.toDomainModel() }


    override suspend fun getMovieById(id: String): MovieD = api.getMovieById(id).toDomainModel()

}