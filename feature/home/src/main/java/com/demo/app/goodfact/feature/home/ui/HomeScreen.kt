package com.demo.app.goodfact.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.random.navigation.randomFactScreen

@Composable
internal fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            HomeBottomNavigationBar(
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPaddingValues ->
        NavHost(
            modifier = Modifier.padding(innerPaddingValues),
            navController = navController,
            startDestination = GoodFactScreen.RandomFactScreen.route
        ) {
            randomFactScreen()
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}
