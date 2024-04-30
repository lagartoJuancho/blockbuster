package com.jda.blockbuster.ui.screens.home

import android.Manifest
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jda.blockbuster.ui.common.Loading
import com.jda.blockbuster.ui.common.PermissionRequestEffect
import com.jda.blockbuster.ui.common.getRegion
import com.jda.blockbuster.ui.model.Movie
import com.jda.blockbuster.ui.model.movies
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
    var appBarColor by remember { mutableStateOf(Color.White) }

    PermissionRequestEffect(permission = Manifest.permission.ACCESS_COARSE_LOCATION) { granted ->
        if(granted) {
            appBarColor = Color(0xFFFFFFFF)
            coroutineScope.launch {
                val region = context.getRegion()
            }
        } else {
            appBarColor = Color(0xFFDFDFDF)
        }
        viewModel.onUiReady()
    }
    Screen {
        val lazyGridState = rememberLazyGridState()
        Scaffold(
            modifier = Modifier.background(Color.White),
            contentWindowInsets = WindowInsets.safeDrawing,
            topBar = {
//                FavoritesAppBar(movies = movies)
                if (state.isLoading) {
                    CollapsedBar(background = appBarColor)
                } else {
                    AnimatedContent(targetState = lazyGridState.isScrolled, transitionSpec = {
                        slideInVertically { fullHeight -> fullHeight } togetherWith slideOutVertically { fullHeight -> fullHeight }
                    }, label = "") { isScrolled ->
                        if (isScrolled) {
                            CollapsedBar(background = appBarColor)
                        } else {
                            FavoritesAppBar(movies = state.movies, background = appBarColor)
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

