package com.demo.app.goodfact.feature.random.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCase
import com.demo.app.goodfact.feature.core.config.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface RandomFactScreenIntent {
    data object GoToPrevious: RandomFactScreenIntent
    data object Share: RandomFactScreenIntent
    data object GoToNext: RandomFactScreenIntent
}

@HiltViewModel
class RandomFactViewModel @Inject constructor(
    private val useCase: FactGeneratorUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(RandomFactViewState())
    val viewState = _viewState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = RandomFactViewState()
    )

    init {
        loadCurrentFact()
        preloadNext()
    }

    fun intentListener(intent: RandomFactScreenIntent) {
        when (intent) {
            RandomFactScreenIntent.GoToPrevious -> goToPrevious()
            RandomFactScreenIntent.GoToNext -> goToNext()
            else -> { /*no-op */ }
        }
    }

    private fun loadCurrentFact() = viewModelScope.launch(Dispatchers.IO) {
        useCase.generateRandomFact()
            .onSuccess { fact ->
                _viewState.update { it.copy(currentFact = fact) }
            }
            .onFailure {
                val randomFact = Constants.storedFacts.random()
                _viewState.update { it.copy(currentFact = randomFact) }
            }
    }

    private fun preloadNext() = viewModelScope.launch(Dispatchers.IO) {
        useCase.generateRandomFact()
            .onSuccess { fact ->
                if (_viewState.value.currentFact?.id == fact.id) {

                } else {
                    _viewState.update { it.copy(preloadFact = fact) }
                }
            }
            .onFailure {
                var randomFact = Constants.storedFacts.random()
                while (randomFact.id == _viewState.value.currentFact?.id) {
                    randomFact = Constants.storedFacts.random()
                }
                _viewState.update { it.copy(preloadFact = randomFact) }
            }
    }

    private fun goToNext() {
        _viewState.update {
            it.copy(
                previousFact = it.currentFact,
                currentFact = it.preloadFact
            )
        }
        preloadNext()
    }

    private fun goToPrevious() {
        if (_viewState.value.previousFact != null) {
            _viewState.update {
                it.copy(
                    previousFact = null,
                    currentFact = it.previousFact,
                    preloadFact = it.currentFact
                )
            }
        }
    }
}
