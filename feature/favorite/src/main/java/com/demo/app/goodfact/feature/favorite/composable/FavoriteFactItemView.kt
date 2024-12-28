package com.demo.app.goodfact.feature.favorite.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.app.goodfact.domain.core.model.Fact
import com.demo.app.goodfact.feature.core.R
import com.demo.app.goodfact.feature.core.config.AppColor

@Composable
internal fun FavoriteFactItemView(
    fact: Fact,
    onRemoveListener: () -> Unit,
    modifier: Modifier = Modifier,
    bgColor: Color = AppColor.blue
) {
    Box(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Icon(
                modifier = Modifier
                    .clickable {
                        onRemoveListener.invoke()
                    },
                painter = painterResource(R.drawable.ic_favorite_24),
                contentDescription = null,
                tint = Color.Red,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                text = fact.content,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = fact.source,
                color = Color.Gray,
                fontSize = 17.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewItemView() {
    FavoriteFactItemView(
        fact = Fact(id = "", content = "This is a sample content view.", source = "im the source"),
        onRemoveListener = { }
    )
}
