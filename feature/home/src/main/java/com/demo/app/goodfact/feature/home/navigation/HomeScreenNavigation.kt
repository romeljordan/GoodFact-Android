package com.demo.app.goodfact.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.home.ui.HomeScreen

fun NavController.navigateToHomeScreen() {
    navigate(route = GoodFactScreen.HomeScreen.route)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = GoodFactScreen.HomeScreen.route) {
        HomeScreen()
    }
}
