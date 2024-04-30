package com.jda.blockbuster.domain.repository

import com.jda.blockbuster.domain.model.MovieD
import com.jda.blockbuster.ui.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun fetchPopularMovies(region: String): List<MovieD>

    suspend fun getMovieById(id: String): MovieD
}