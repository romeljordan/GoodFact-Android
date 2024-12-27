package com.demo.app.goodfact.feature.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.composable.FactCardView
import com.demo.app.goodfact.feature.core.composable.LoadingAnimationView
import com.demo.app.goodfact.feature.core.config.AppColor
import com.demo.app.goodfact.feature.daily.viewmodel.DailyFactViewModel

@Composable
internal fun DailyFactRoute(
    viewModel: DailyFactViewModel = hiltViewModel()
) {
    val dailyFact by viewModel.currentFact.collectAsStateWithLifecycle()

    dailyFact?.let {
        DailyFactScreen(it)
    } ?: LoadingAnimationView(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.ghostWhite)
    )

}

@Composable
private fun DailyFactScreen(
    currentFact: Fact
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColor.ghostWhite
    ) { innerPadding ->
        FactCardView(
            fact = currentFact,
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        )
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewDailyFactScreen() {
    DailyFactScreen(currentFact = Fact(id = "", content = "This is a sample content.", source = "new source"))
}
