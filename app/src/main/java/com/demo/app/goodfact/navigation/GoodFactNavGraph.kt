package com.demo.app.goodfact.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.home.navigation.homeScreen

@Composable
internal fun GoodFactNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = GoodFactScreen.HomeScreen.route
    ) {
        homeScreen() // TODO: add onResultCallback
    }
}
