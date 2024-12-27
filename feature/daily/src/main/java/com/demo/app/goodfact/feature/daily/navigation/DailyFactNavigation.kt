package com.demo.app.goodfact.feature.daily.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.daily.DailyFactRoute

fun NavController.navigateToDailyFact() {
    navigate(route = GoodFactScreen.DailyFactScreen.route)
}

fun NavGraphBuilder.dailyFactScreen() {
    composable(route = GoodFactScreen.DailyFactScreen.route) {
        DailyFactRoute()
    }
}
