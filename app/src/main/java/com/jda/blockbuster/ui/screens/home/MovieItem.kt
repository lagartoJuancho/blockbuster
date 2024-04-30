package com.jda.blockbuster.ui.screens.home

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.jda.blockbuster.ui.model.Movie

@Composable
fun MovieItem(onClick: () -> Unit, movie: Movie) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        ConstraintLayout {
            val (poster, voteAverage, title, date) = createRefs()
            AsyncImage(
                model = movie.poster,
                contentDescription = movie.title,
                modifier = Modifier
                    .constrainAs(poster) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .aspectRatio(2 / 3f)
                    .clip(MaterialTheme.shapes.small)
            )
            VoteAverage(
                movie = movie,
                modifier = Modifier.constrainAs(voteAverage) {
                    start.linkTo(poster.start, margin = 12.dp)
                    bottom.linkTo(poster.bottom, margin = (-21).dp)
                })
            MovieTitle(
                title = movie.title,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(voteAverage.start)
                    top.linkTo(voteAverage.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )
            MovieSecondaryText(
                movie = movie,
                modifier = Modifier.constrainAs(date) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}
