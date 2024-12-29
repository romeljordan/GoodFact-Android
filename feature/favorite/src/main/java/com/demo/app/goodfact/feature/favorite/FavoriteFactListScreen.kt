package com.demo.app.goodfact.feature.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Favorites",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            if (favorites.isEmpty()) {
                Text(
                    text = "No favorite facts yet.",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(16.dp)
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
