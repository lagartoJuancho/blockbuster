package com.jda.blockbuster.ui.screens.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteItem(modifier: Modifier, image: String, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Avatar(modifier = modifier, image = image)
        Text(modifier = modifier.width(52.dp),
            textAlign = TextAlign.Center,
            color = Color.Black,
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}