package com.demo.app.goodfact.feature.random.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.app.goodfact.feature.core.config.AppColor

@Composable
internal fun ActionButton(
    @DrawableRes iconIdRes: Int,
    onClickListener: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    color: Color = AppColor.blue
) {
    Box(
        modifier = modifier
            .alpha(if (isEnabled) 1f else 0.6f)
            .border(
                width = (1.5).dp,
                color = color,
                shape = CircleShape
            )
            .clickable(enabled = isEnabled) { onClickListener?.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .padding(16.dp)
                .size(35.dp),
            painter = painterResource(id = iconIdRes),
            contentDescription = null,
            tint = color
        )
    }
}
