package com.jda.blockbuster.ui.screens.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jda.blockbuster.ui.model.Movie

@Composable
fun MovieSecondaryText(movie: Movie, modifier: Modifier){
    Text(
        text = movie.releaseDate,
        style = MaterialTheme.typography.labelSmall,
        maxLines = 1,
        modifier = modifier,
        color = Color.Gray
    )
}