package com.demo.app.goodfact.feature.daily.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.domain.core.usecase.FactGeneratorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyFactViewModel @Inject constructor(
    private val useCase: FactGeneratorUseCase
) : ViewModel() {
    private val _currentFact = MutableStateFlow<Fact?>(null)
    val currentFact = _currentFact.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )

    init {
        loadDailyFact()
    }

    fun addToFavorites() {
        // TODO: add to room database in favorite list
    }

    private fun loadDailyFact() = viewModelScope.launch(Dispatchers.IO) {
        useCase.generateDailyFact()
            .onSuccess { fact ->
                _currentFact.emit(fact)
            }
    }
}
