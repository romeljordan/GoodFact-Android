package com.demo.app.goodfact.feature.core

sealed class GoodFactScreen(val route: String) {
    data object HomeScreen : GoodFactScreen("home_screen_nav_route")
    data object RandomFactScreen : GoodFactScreen("random_fact_screen_nav_route")
    data object DailyFactScreen : GoodFactScreen("daily_fact_screen_nav_route")
    data object FavoriteFactListScreen : GoodFactScreen("favorite_fact_list_screen_nav_route")
}
