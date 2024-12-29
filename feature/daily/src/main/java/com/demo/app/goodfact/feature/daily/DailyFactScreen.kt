package com.demo.app.goodfact.feature.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.composable.FactCardView
import com.demo.app.goodfact.feature.core.composable.LoadingAnimationView
import com.demo.app.goodfact.feature.core.config.AppColor
import com.demo.app.goodfact.feature.daily.viewmodel.DailyFactIntent
import com.demo.app.goodfact.feature.daily.viewmodel.DailyFactViewModel
import com.demo.app.goodfact.feature.daily.viewmodel.DailyFactViewState

@Composable
internal fun DailyFactRoute(
    viewModel: DailyFactViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    DailyFactScreen(
        viewState = viewState,
        intentListener = viewModel::bindIntentListener
    )
}

@Composable
private fun DailyFactScreen(
    viewState: DailyFactViewState,
    intentListener: (intent: DailyFactIntent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColor.ghostWhite
    ) { innerPadding ->
        viewState.current?.let { currentFact ->
            FactCardView(
                fact = currentFact,
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                isFavorite = viewState.isFavorite,
                onTapFavorite = { value ->
                    when (value) {
                        true -> intentListener.invoke(DailyFactIntent.SaveToFavorites)
                        false -> intentListener.invoke(DailyFactIntent.RemoveToFavorites)
                    }
                }
            )
        } ?: LoadingAnimationView(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            bgColor = Color.Transparent
        )
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewDailyFactScreen() {
    DailyFactScreen(
        viewState = DailyFactViewState(
            current = Fact(id = "", content = "This is a sample content.", source = "new source")
        ),
        intentListener = { }
    )
}
