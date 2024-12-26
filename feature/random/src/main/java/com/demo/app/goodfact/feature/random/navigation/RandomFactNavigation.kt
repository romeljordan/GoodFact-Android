package com.demo.app.goodfact.feature.random.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.random.RandomFactRoute

fun NavController.navigateToRandomFact() {
    navigate(route = GoodFactScreen.RandomFactScreen.route)
}

fun NavGraphBuilder.randomFactScreen() {
    composable(route = GoodFactScreen.RandomFactScreen.route) {
        RandomFactRoute()
    }
}
