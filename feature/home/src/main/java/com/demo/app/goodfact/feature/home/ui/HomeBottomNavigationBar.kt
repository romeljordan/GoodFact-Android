package com.demo.app.goodfact.feature.home.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.demo.app.goodfact.feature.core.GoodFactScreen
import com.demo.app.goodfact.feature.core.R
import com.demo.app.goodfact.feature.core.bottomBarScreens

@Composable
internal fun HomeBottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedScreen: GoodFactScreen,
    onSelectScreen: (screen: GoodFactScreen) -> Unit
) {
    NavigationBar(
        modifier = modifier
    ) {
        bottomBarScreens.forEach { screen ->
            NavigationBarItem(
                selected = selectedScreen == screen,
                icon = {
                    Icon(
                        painter = painterResource(
                            when (screen) {
                                GoodFactScreen.RandomFactScreen -> R.drawable.ic_notes_24
                                GoodFactScreen.DailyFactScreen -> R.drawable.ic_today_24
                                GoodFactScreen.FavoriteFactListScreen -> R.drawable.ic_favorite_24
                                else -> R.drawable.ic_notes_24
                            }
                        ),
                        contentDescription = null
                    )
                },
                onClick = { onSelectScreen.invoke(screen) }
            )
        }
    }
}
