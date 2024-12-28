package com.keo.genres_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keo.source.base.GenreRepository
import com.keo.source.base.UiState
import com.keo.source.base.dto.Genre
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class GenresFeatureVM @AssistedInject constructor(
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Genre>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Genre>>> = _state

    fun loadGenres() {
        viewModelScope.launch {
            flow {
                emit(UiState.Loading)
                val genres = genreRepository.getGenres()
                emit(UiState.Success(genres))
            }
                .catch { e -> emit(UiState.Error(e.message ?: "Unknown error")) }
                .collect { newState -> _state.value = newState }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): GenresFeatureVM
    }
}