package com.demo.app.goodfact.feature.random.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

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
        // TODO: load latest facts
    }

    private fun loadInitFact() = viewModelScope.launch(Dispatchers.IO) {
        useCase.generateRandomFact()
            .onSuccess {

            }
            .onFailure {

            }
    }
}
