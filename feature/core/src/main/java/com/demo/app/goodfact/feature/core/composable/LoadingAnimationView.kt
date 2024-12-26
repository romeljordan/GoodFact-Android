package com.demo.app.goodfact.feature.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingAnimationView(
    modifier: Modifier = Modifier,
    bgColor: Color = Color.Black.copy(alpha = 0.75f)
) {
    Box(
        modifier = modifier
            .background(bgColor)
            .clickable { /* no-op */ },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
