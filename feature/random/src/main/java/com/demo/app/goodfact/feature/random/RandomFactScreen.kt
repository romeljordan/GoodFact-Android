package com.demo.app.goodfact.feature.random

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.composable.FactCardView
import com.demo.app.goodfact.feature.core.config.Constants
import com.demo.app.goodfact.feature.random.viewmodel.RandomFactViewModel
import com.demo.app.goodfact.feature.random.viewmodel.RandomFactViewState

@Composable
internal fun RandomFactRoute(
    viewModel: RandomFactViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    RandomFactScreen(state = viewState)
}

@Composable
private fun RandomFactScreen(state: RandomFactViewState) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            state.currentFact?.let { fact ->
                FactCardView(
                    fact = Fact(id = fact.id, content = fact.content, source = fact.source),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { }
                ) {

                }
            }
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewRandomFactScreen() {
    RandomFactScreen(
        state = RandomFactViewState(currentFact = Constants.storedFacts.random())
    )
}
