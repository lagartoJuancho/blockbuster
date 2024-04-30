package com.jda.blockbuster.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jda.blockbuster.ui.model.Movie

@Composable
fun MovieList(onClick: (Movie) -> Unit, modifier: Modifier, movies: List<Movie>, lazyListState: LazyGridState) {
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
            .background(Color.White),
        columns = GridCells.Adaptive(120.dp),
        state = lazyListState
    ) {
        items(movies) { movie ->
            MovieItem(onClick = { onClick(movie) }, movie = movie)
        }
    }
}
