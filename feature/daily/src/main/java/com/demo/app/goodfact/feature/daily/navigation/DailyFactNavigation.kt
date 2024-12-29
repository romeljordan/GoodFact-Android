package com.demo.app.goodfact.feature.daily.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.daily.DailyFactRoute

fun NavController.navigateToDailyFact(navOptions: NavOptions? = null) {
    navigate(route = GoodFactScreen.DailyFactScreen.route, navOptions = navOptions)
}

fun NavGraphBuilder.dailyFactScreen() {
    composable(route = GoodFactScreen.DailyFactScreen.route) {
        DailyFactRoute()
    }
}
