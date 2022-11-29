package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.*

@Composable
fun Lottie(resId: Int) {
    val resource by rememberLottieComposition(LottieCompositionSpec.RawRes(resId))

    val animation by
    animateLottieCompositionAsState(
        composition = resource,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        restartOnPlay = true
    )

    Box {
        LottieAnimation(
            resource,
            animation,
        )
    }

}