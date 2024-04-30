package com.jda.blockbuster.ui.screens.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MovieTitle(title: String, modifier: Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        maxLines = 2,
        minLines = 2,
        modifier = modifier,
        color = Color.Black
    )
}