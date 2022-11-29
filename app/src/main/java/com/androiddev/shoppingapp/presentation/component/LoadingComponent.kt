package com.androiddev.shoppingapp.presentation.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.androiddev.shoppingapp.ui.theme.LoadingEndColor
import com.androiddev.shoppingapp.ui.theme.LoadingStartColor


@Composable
fun LoadingAnimation(
    indicatorSize: Dp = 36.dp,
    circleColors: List<Color> = listOf(
        LoadingStartColor,
        LoadingEndColor,
    ),
    animationDuration: Int = 500
) {

    val infiniteTransition = rememberInfiniteTransition()

    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            )
        )
    )

    CircularProgressIndicator(
        modifier = Modifier
            .testTag("loaging")
            .size(size = indicatorSize)
            .rotate(degrees = rotateAnimation)
            .border(
                width = 3.dp,
                brush = Brush.sweepGradient(circleColors),
                shape = CircleShape
            ),
        progress = 1f,
        strokeWidth = 3.dp,
        color = Color.Transparent // Set background color
    )
}
