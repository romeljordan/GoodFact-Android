package com.demo.app.goodfact.feature.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.config.AppColor
import com.demo.app.goodfact.feature.favorite.composable.FavoriteFactItemView
import com.demo.app.goodfact.feature.favorite.viewmodel.FavoriteFactListScreenIntent
import com.demo.app.goodfact.feature.favorite.viewmodel.FavoriteFactListViewModel

@Composable
internal fun FavoriteFactListRoute(
    viewModel: FavoriteFactListViewModel = hiltViewModel()
) {
    val facts by viewModel.favorites.collectAsStateWithLifecycle()

    FavoriteFactListScreen(
        favorites = facts,
        intentListener = viewModel::bindIntentListener
    )
}

@Composable
private fun FavoriteFactListScreen(
    favorites: List<Fact>,
    intentListener: (intent: FavoriteFactListScreenIntent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColor.ghostWhite
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            favorites.forEachIndexed { index, fact ->
                item(key = fact.id) {
                    FavoriteFactItemView(
                        fact = fact,
                        onRemoveListener = {
                            intentListener.invoke(FavoriteFactListScreenIntent.Remove(fact.id))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        bgColor = AppColor.paletteOrder[index % AppColor.paletteOrder.size]
                    )
                }
            }
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewFavoriteFactListScreen() {
    FavoriteFactListScreen(
        favorites = listOf(
            Fact(id = "1", content = "This it the first favorite content by the user.", source = "none"),
            Fact(id = "2", content = "This it the second favorite content by the user.", source = "none")
        ),
        intentListener = { }
    )
}
