package com.demo.app.goodfact.feature.random.viewmodel

import com.demo.app.goodfact.domain.core.model.Fact

data class RandomFactViewState(
    val currentFact: Fact? = null,
    val preloadFact: Fact? = null,
    val previousFact: Fact? = null,
    val favoritesId: List<String> = emptyList()
)
