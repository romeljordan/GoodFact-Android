package com.demo.app.goodfact.feature.random

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Random Fact"
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Content fact"
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "source: Source"
                    )
                }
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun PreviewRandomFactScreen() {
    RandomFactScreen(state = RandomFactViewState())
}
