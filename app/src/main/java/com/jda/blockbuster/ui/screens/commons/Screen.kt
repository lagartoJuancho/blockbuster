package com.jda.blockbuster.ui.screens.commons

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jda.blockbuster.ui.theme.BlockBusterTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    BlockBusterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}