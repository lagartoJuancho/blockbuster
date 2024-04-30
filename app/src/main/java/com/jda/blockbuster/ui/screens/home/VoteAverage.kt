package com.jda.blockbuster.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.jda.blockbuster.ui.model.Movie
import com.jda.blockbuster.ui.theme.Primary

@Composable
fun VoteAverage(movie: Movie, modifier: Modifier) {
    Box(
        modifier = modifier
            .height(42.dp)
            .width(42.dp)
            .background(Color.DarkGray, shape = CircleShape)
    ) {
        CircularProgressIndicator(
            progress = {
                movie.voteAverage / 10f
            },
            modifier = Modifier
                .size(38.dp)
                .align(Alignment.Center),
            color = Primary,
            strokeWidth = 3.dp,
        )
        Row(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = movie.voteAverage.toString(),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
            )
            Text(
                text = "%",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                fontSize = 8.sp,
                modifier = Modifier.align(Alignment.Top)

            )
        }
    }
}
