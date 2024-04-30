package com.jda.blockbuster.domain.model

import com.jda.blockbuster.data.remote.model.MovieDTO

data class MovieD(
    val id: String,
    val title: String,
    val poster: String,
    val voteAverage: Double,
    val releaseDate: String,
)

fun MovieDTO.toDomainModel(): MovieD {
    return MovieD(
        id = id.toString(),
        title = title,
        poster = "https://image.tmdb.org/t/p/w185/$posterPath",
        voteAverage = voteAverage,
        releaseDate = releaseDate
    )
}