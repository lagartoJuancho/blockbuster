package com.jda.blockbuster.data.remote

import com.jda.blockbuster.data.remote.model.MovieDTO
import com.jda.blockbuster.data.remote.model.ResultDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun fetchPopularMovies( @Query("region") region: String): ResultDTO

    @GET("movie/{id}")
    suspend fun getMovieById( @Path("id") id: String): MovieDTO

}