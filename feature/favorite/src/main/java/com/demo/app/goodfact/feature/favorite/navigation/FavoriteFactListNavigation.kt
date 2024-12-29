package com.demo.app.goodfact.feature.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.favorite.FavoriteFactListRoute

fun NavController.navigateToFavoriteFactList(navOptions: NavOptions? = null) {
    navigate(
        route = GoodFactScreen.FavoriteFactListScreen.route,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.favoriteFactListScreen() {
    composable(route = GoodFactScreen.FavoriteFactListScreen.route) {
        FavoriteFactListRoute()
    }
}
