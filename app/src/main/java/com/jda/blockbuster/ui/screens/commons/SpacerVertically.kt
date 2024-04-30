package com.jda.blockbuster.ui.screens.commons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpaceVertically(height: Dp) {
    Spacer(modifier = Modifier.size(height))
}