package com.demo.app.goodfact.feature.random.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.random.RandomFactRoute

fun NavController.navigateToRandomFact(navOptions: NavOptions? = null) {
    navigate(route = GoodFactScreen.RandomFactScreen.route, navOptions = navOptions)
}

fun NavGraphBuilder.randomFactScreen() {
    composable(route = GoodFactScreen.RandomFactScreen.route) {
        RandomFactRoute()
    }
}
