package com.jda.blockbuster.ui.screens.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jda.blockbuster.R
import com.jda.blockbuster.ui.model.Movie

@Composable
fun CollapsedBar(size: Int = 42, background: Color = Color.White) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .padding(top = 22.dp, bottom = 8.dp)
    ) {
        val (search, qr, logo) = createRefs()
        SearchRoundView(
            modifier = Modifier.constrainAs(search) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            size = size
        )
        QrRoundView(
            modifier = Modifier.constrainAs(qr) {
                start.linkTo(search.end, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            size = size
        )
        Logo(
            modifier = Modifier.constrainAs(logo) {
                end.linkTo(parent.end, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }
        )
    }
}

@Composable
fun SearchRoundView(modifier: Modifier, size: Int = 52) {
    RoundedIconView(
        modifier = modifier,
        icon = Icons.Default.Search,
        contentDescription = "Search",
        size = size
    )
}

@Composable
fun QrRoundView(modifier: Modifier, size: Int = 52) {
    RoundedIconView(
        modifier = modifier,
        icon = Icons.Default.Add,
        contentDescription = "Qr Scan",
        size = size
    )
}

@Composable
fun RoundedIconView(
    modifier: Modifier,
    icon: ImageVector,
    contentDescription: String = "",
    size: Int = 52
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .border(1.dp, Color.LightGray, CircleShape)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.Black
        )
    }
}

@Composable
fun Logo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo2),
        contentDescription = "BlockBuster",
        modifier = modifier
            .height(30.dp),
        contentScale = ContentScale.Inside
    )
}

@Composable
fun FavoritesAppBar(movies: List<Movie>, background: Color = Color.White) {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, top = 22.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
    ) {
        item {
            SearchItem(modifier = Modifier)
        }
        items(movies) { movie ->
            FavoriteItem(modifier = Modifier, image = movie.poster, name = movie.title)
        }
    }
}