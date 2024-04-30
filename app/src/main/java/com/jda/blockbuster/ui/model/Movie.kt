package com.jda.blockbuster.ui.model

import com.jda.blockbuster.domain.model.MovieD

data class Movie(
    val id: String,
    val title: String,
    val poster: String,
    val voteAverage: Int,
    val releaseDate: String,
)

fun MovieD.toUiModel() = Movie(
    id = id,
    title = title,
    poster = poster,
    voteAverage = voteAverage.toInt(),
    releaseDate = releaseDate
)

val movies = (1..100).map {
    Movie(
        id = it.toString(),
        title = "Movie $it",
        voteAverage = (1..10).random(),
        poster = "https://picsum.photos/200/300?id=$it",
        releaseDate = "2021-09-01"
    )
}