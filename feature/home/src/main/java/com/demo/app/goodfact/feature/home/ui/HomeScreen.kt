package com.demo.app.goodfact.feature.home.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.daily.navigation.dailyFactScreen
import com.demo.app.goodfact.feature.daily.navigation.navigateToDailyFact
import com.demo.app.goodfact.feature.favorite.navigation.favoriteFactListScreen
import com.demo.app.goodfact.feature.favorite.navigation.navigateToFavoriteFactList
import com.demo.app.goodfact.feature.random.navigation.navigateToRandomFact
import com.demo.app.goodfact.feature.random.navigation.randomFactScreen

@Composable
internal fun HomeScreen() {
    val navController = rememberNavController()
    var selectedScreen by remember { mutableStateOf<GoodFactScreen>(GoodFactScreen.RandomFactScreen) }

    LaunchedEffect(selectedScreen) {
        when (selectedScreen) {
            GoodFactScreen.RandomFactScreen -> navController.navigateToRandomFact()
            GoodFactScreen.DailyFactScreen -> navController.navigateToDailyFact()
            GoodFactScreen.FavoriteFactListScreen -> navController.navigateToFavoriteFactList()
            else -> { /* no-op */ }
        }
    }

    Scaffold(
        bottomBar = {
            HomeBottomNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                selectedScreen = selectedScreen,
                onSelectScreen = { selectedScreen = it }
            )
        }
    ) { innerPaddingValues ->
        NavHost(
            modifier = Modifier.padding(innerPaddingValues),
            navController = navController,
            startDestination = GoodFactScreen.RandomFactScreen.route
        ) {
            randomFactScreen()

            dailyFactScreen()

            favoriteFactListScreen()
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}
