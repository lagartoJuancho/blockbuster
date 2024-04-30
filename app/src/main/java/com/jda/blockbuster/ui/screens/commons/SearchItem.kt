package com.jda.blockbuster.ui.screens.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SearchItem(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SearchRoundView(modifier = modifier)
        Text(modifier = Modifier
            .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black,text = "Search",
            maxLines = 1)
    }
}