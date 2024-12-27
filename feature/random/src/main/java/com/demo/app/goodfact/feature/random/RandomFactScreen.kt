package com.demo.app.goodfact.feature.random

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.R
import com.demo.app.goodfact.feature.core.composable.FactCardView
import com.demo.app.goodfact.feature.core.composable.LoadingAnimationView
import com.demo.app.goodfact.feature.core.config.AppColor
import com.demo.app.goodfact.feature.core.config.Constants
import com.demo.app.goodfact.feature.random.composable.ActionButton
import com.demo.app.goodfact.feature.random.viewmodel.RandomFactScreenIntent
import com.demo.app.goodfact.feature.random.viewmodel.RandomFactViewModel
import com.demo.app.goodfact.feature.random.viewmodel.RandomFactViewState

@Composable
internal fun RandomFactRoute(
    viewModel: RandomFactViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    RandomFactScreen(
        state = viewState,
        intentListener = viewModel::intentListener
    )
}

@Composable
private fun RandomFactScreen(
    state: RandomFactViewState,
    intentListener: (intent: RandomFactScreenIntent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColor.ghostWhite
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            state.currentFact?.let { fact ->
                FactCardView(
                    fact = Fact(id = fact.id, content = fact.content, source = fact.source),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            } ?: LoadingAnimationView(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                bgColor = Color.Transparent
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton(
                    iconIdRes = R.drawable.ic_keyboard_backspace_24,
                    isEnabled = state.previousFact != null,
                    onClickListener = {
                        intentListener.invoke(RandomFactScreenIntent.GoToPrevious)
                    },
                    color = AppColor.blue
                )

                ActionButton(
                    iconIdRes = R.drawable.ic_share_24,
                    color = AppColor.blue,
                    onClickListener = {

                    }
                )

                ActionButton(
                    iconIdRes = R.drawable.ic_arrow_forward_24,
                    color = AppColor.blue,
                    isEnabled = state.preloadFact != null,
                    onClickListener =  {
                        intentListener.invoke(RandomFactScreenIntent.GoToNext)
                    }
                )
            }
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewRandomFactScreen() {
    RandomFactScreen(
        state = RandomFactViewState(currentFact = Constants.storedFacts.random()),
        intentListener = { }
    )
}
