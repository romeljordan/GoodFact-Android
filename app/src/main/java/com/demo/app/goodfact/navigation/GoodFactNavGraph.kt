package com.demo.app.goodfact.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
internal fun GoodFactNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ""
    ) {

    }
}
