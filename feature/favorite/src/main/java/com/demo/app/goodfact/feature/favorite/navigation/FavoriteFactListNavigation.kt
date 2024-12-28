package com.demo.app.goodfact.feature.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.favorite.FavoriteFactListRoute

fun NavController.navigateToFavoriteFactList() {
    navigate(route = GoodFactScreen.FavoriteFactListScreen.route)
}

fun NavGraphBuilder.favoriteFactListScreen() {
    composable(route = GoodFactScreen.FavoriteFactListScreen.route) {
        FavoriteFactListRoute()
    }
}
