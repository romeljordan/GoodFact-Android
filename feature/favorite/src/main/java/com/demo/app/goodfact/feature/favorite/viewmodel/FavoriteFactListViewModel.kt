package com.demo.app.goodfact.feature.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.usecase.FavoriteFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteFactListViewModel @Inject constructor(
    private val useCase: FavoriteFactUseCase
) : ViewModel() {
    private val _favorites = MutableStateFlow<List<Fact>>(emptyList())
    val favorites = _favorites.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    init {
        fetchFavorites()
    }

    fun removeFavorite(id: String) = viewModelScope.launch(Dispatchers.IO) {
        useCase.removeFavorite(id)
    }

    private fun fetchFavorites() = viewModelScope.launch(Dispatchers.IO) {
        useCase.fetchFavorites().collectLatest { faves ->
            _favorites.update { faves }
        }
    }
}
