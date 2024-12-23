package com.demo.app.goodfact.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.demo.app.goodfact.navigation.GoodFactNavGraph
import com.demo.app.goodfact.ui.theme.GoodFactTheme

@Composable
internal fun GoodFactApp() {
    GoodFactTheme {
        GoodFactNavGraph()
    }
}
