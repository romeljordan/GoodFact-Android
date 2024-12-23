package com.demo.app.goodfact.feature.home.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.demo.app.goodfact.feature.core.R

@Composable
internal fun HomeBottomNavigationBar(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_notes_24),
                    contentDescription = null
                )
            },
            onClick = {

            }
        )

        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_today_24),
                    contentDescription = null
                )
            },
            onClick = {

            }
        )

        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite_24),
                    contentDescription = null
                )
            },
            onClick = {

            }
        )
    }
}
