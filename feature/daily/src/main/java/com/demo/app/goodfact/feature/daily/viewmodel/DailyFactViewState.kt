package com.demo.app.goodfact.feature.daily.viewmodel

import com.demo.app.goodfact.domain.core.model.Fact

data class DailyFactViewState(
    val current: Fact? = null,
    val isFavorite: Boolean = false
)
