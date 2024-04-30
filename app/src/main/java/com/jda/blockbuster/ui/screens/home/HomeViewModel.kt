package com.jda.blockbuster.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jda.blockbuster.domain.repository.MoviesRepository
import com.jda.blockbuster.ui.model.Movie
import com.jda.blockbuster.ui.model.movies
import com.jda.blockbuster.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MoviesRepository
): ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun onUiReady() {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            val movieList = repository.fetchPopularMovies().map { movie ->
                movie.toUiModel()
            }
            state= UiState(isLoading = false, movies = movieList)
        }
    }
    data class UiState(
        val isLoading: Boolean = true,
        val movies: List<Movie> = emptyList(),
        val isScrolled: Boolean = false,
        val appBarrIsCollapsed: Boolean = false
    )
}