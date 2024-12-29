package com.demo.app.goodfact.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.daily.navigation.navigateToDailyFact
import com.demo.app.goodfact.feature.favorite.navigation.navigateToFavoriteFactList
import com.demo.app.goodfact.feature.home.ui.HomeScreen
import com.demo.app.goodfact.feature.random.navigation.navigateToRandomFact

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    navigate(route = GoodFactScreen.HomeScreen.route, navOptions = navOptions)
}

fun NavController.navigateToTabTop(screenType: GoodFactScreen) {
     val tabTopNavOption = navOptions {
        graph.startDestinationRoute?.let { route ->
         popUpTo(route) {
             saveState = true
         }
        }

        launchSingleTop = true
        restoreState = true
    }

    when (screenType) {
        GoodFactScreen.RandomFactScreen -> navigateToRandomFact(navOptions = tabTopNavOption)
        GoodFactScreen.DailyFactScreen -> navigateToDailyFact(navOptions = tabTopNavOption)
        GoodFactScreen.FavoriteFactListScreen -> navigateToFavoriteFactList(navOptions = tabTopNavOption)
        else -> { /* no-op */ }
    }
}

fun NavGraphBuilder.homeScreen() {
    composable(route = GoodFactScreen.HomeScreen.route) {
        HomeScreen()
    }
}
