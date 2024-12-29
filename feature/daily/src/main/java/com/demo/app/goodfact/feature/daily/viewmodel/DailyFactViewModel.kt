package com.demo.app.goodfact.feature.daily.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCase
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

sealed interface DailyFactIntent {
    data object SaveToFavorites : DailyFactIntent
    data object RemoveToFavorites : DailyFactIntent
}

@HiltViewModel
class DailyFactViewModel @Inject constructor(
    private val useCase: FactGeneratorUseCase,
    private val favoriteFactUseCase: FavoriteFactUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(DailyFactViewState())
    val viewState = _viewState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = DailyFactViewState()
    )

    init {
        loadDailyFact()
    }

    fun bindIntentListener(intent: DailyFactIntent) {
        when (intent) {
            DailyFactIntent.SaveToFavorites -> addToFavorites()
            DailyFactIntent.RemoveToFavorites -> removeFavoriteFact()
        }
    }

    private fun fetchFavorites() = viewModelScope.launch(Dispatchers.IO) {
        favoriteFactUseCase.fetchFavorites().collectLatest { favorites ->
            _viewState.update {
                it.copy(
                    isFavorite = it.current?.let { fact -> favorites.contains(fact) } ?: false
                )
            }
        }
    }

    private fun addToFavorites() = viewModelScope.launch(Dispatchers.IO) {
        _viewState.value.current?.let {
            favoriteFactUseCase.addFavorite(it)
        }
    }

    private fun removeFavoriteFact() = viewModelScope.launch(Dispatchers.IO) {
        _viewState.value.current?.let {
            favoriteFactUseCase.removeFavorite(it.id)
        }
    }

    private fun loadDailyFact() = viewModelScope.launch(Dispatchers.IO) {
        useCase.generateDailyFact()
            .onSuccess { fact ->
                _viewState.update {
                    it.copy(current = fact)
                }
                fetchFavorites()
            }
    }
}
