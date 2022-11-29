package com.androiddev.shoppingapp.presentation.component.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerGridItem(brush: Brush) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentSize()
            .padding(all = 4.dp)
    ) {

        Spacer(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(140.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(brush)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Spacer(
            modifier = Modifier
                .width(140.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Spacer(
            modifier = Modifier
                .width(140.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
        )
        Spacer(modifier = Modifier.width(8.dp))

    }

}