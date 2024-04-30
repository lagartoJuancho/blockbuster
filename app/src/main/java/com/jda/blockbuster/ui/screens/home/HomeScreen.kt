package com.jda.blockbuster.ui.screens.home

import android.Manifest
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jda.blockbuster.ui.common.Loading
import com.jda.blockbuster.ui.common.PermissionRequestEffect
import com.jda.blockbuster.ui.common.getRegion
import com.jda.blockbuster.ui.model.Movie
import com.jda.blockbuster.ui.screens.commons.CollapsedBar
import com.jda.blockbuster.ui.screens.commons.FavoritesAppBar
import com.jda.blockbuster.ui.screens.commons.Screen
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onItemClick: (Movie) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state

    PermissionRequestEffect(permission = Manifest.permission.ACCESS_COARSE_LOCATION) { granted ->
        coroutineScope.launch {
            val region = if (granted) {
                context.getRegion()
            } else {
                "US"
            }
            viewModel.onUiReady(region)
        }

    }
    Screen {
        val lazyGridState = rememberLazyGridState()
        Scaffold(
            modifier = Modifier.background(Color.White),
            contentWindowInsets = WindowInsets.safeDrawing,
            topBar = {
                if (state.isLoading) {
                    CollapsedBar(background = Color.White)
                } else {
                    AnimatedContent(targetState = lazyGridState.isScrolled, transitionSpec = {
                        slideInVertically { fullHeight -> fullHeight } togetherWith slideOutVertically { fullHeight -> fullHeight }
                    }, label = "") { isScrolled ->
                        if (isScrolled) {
                            CollapsedBar(background = Color.White)
                        } else {
                            FavoritesAppBar(movies = state.movies, background = Color.White)
                        }
                    }
                }
            },
            contentColor = Color.White
        ) { padding ->
            if (state.isLoading) {
                Loading(padding)
            } else {
                MovieList(
                    onClick = onItemClick,
                    modifier = Modifier.padding(padding),
                    movies = state.movies,
                    lazyListState = lazyGridState
                )
            }
        }
    }
}

val LazyGridState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0

