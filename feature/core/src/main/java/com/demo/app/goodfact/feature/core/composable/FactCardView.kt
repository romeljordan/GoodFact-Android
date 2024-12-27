package com.demo.app.goodfact.feature.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun FactCardView(
    fact: Fact,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    bgColor: Color = AppColor.blue
) {
    Box(
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Icon(
            painter = painterResource(
                if (isFavorite) R.drawable.ic_favorite_24
                else R.drawable.ic_favorite_border_24
            ),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .clickable {
                    // TODO: add functionality
                },
            tint = Color.White
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Random Fact",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = fact.content,
                textAlign = TextAlign.Start,
                color = Color.White, fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "source: ${fact.source}",
                color = Color.Gray,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun PreviewFactCard() {
    FactCardView(
        modifier = Modifier.fillMaxSize(),
        fact = Fact(
            id = "",
            content = "This is a content of random fun fact.",
            source = "me"
        )
    )
}
