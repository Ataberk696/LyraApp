package com.turkcell.lyraapp.ui.home

import androidx.lifecycle.ViewModel
import com.turkcell.lyraapp.data.mock.MockRepository
import com.turkcell.lyraapp.data.model.Category
import com.turkcell.lyraapp.data.model.Playlist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeUiState(
    val categories: List<Category> = emptyList(),
    val recentlyPlayed: List<Playlist> = emptyList(),
    val playlistsForYou: List<Playlist> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mockRepository: MockRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        _uiState.value = _uiState.value.copy(isLoading = true)

        val categories = mockRepository.getCategories()
        val recentlyPlayed = mockRepository.getRecentlyPlayed()
        val playlistsForYou = mockRepository.getPlaylistsForYou()

        _uiState.value = HomeUiState(
            categories = categories,
            recentlyPlayed = recentlyPlayed,
            playlistsForYou = playlistsForYou,
            isLoading = false
        )
    }
}
