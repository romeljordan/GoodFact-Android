package com.demo.app.goodfact.feature.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.favorite.viewmodel.FavoriteFactListViewModel

@Composable
internal fun FavoriteFactListRoute(
    viewModel: FavoriteFactListViewModel = hiltViewModel()
) {
    val facts by viewModel.favorites.collectAsStateWithLifecycle()

    FavoriteFactListScreen(favorites = facts)
}

@Composable
private fun FavoriteFactListScreen(favorites: List<Fact>) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            favorites.forEach { fact ->

            }
        }
    }
}
