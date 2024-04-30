package com.jda.blockbuster.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jda.blockbuster.domain.repository.MoviesRepository
import com.jda.blockbuster.ui.model.Movie
import com.jda.blockbuster.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MoviesRepository
): ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun getMovieById(id: String) {
        state = UiState(isLoading = true)
        viewModelScope.launch {
            val movie = repository.getMovieById(id)
            state = UiState(isLoading = false, movie = movie.toUiModel())
        }
    }
    data class UiState(
        val isLoading: Boolean = true,
        val movie: Movie? = null
    )
}