package com.demo.app.goodfact.feature.core

sealed class GoodFactScreen(val route: String) {
    data object HomeScreen : GoodFactScreen("home_screen_nav_route")
}
