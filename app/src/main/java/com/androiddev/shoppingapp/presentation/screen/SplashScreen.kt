package com.androiddev.shoppingapp.presentation.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.ui.UiEvent
import com.androiddev.shoppingapp.util.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.presentation.component.Lottie

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        withContext(Dispatchers.Main) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(
                    durationMillis = 200,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
        }
    }
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            delay(Constant.SPLASH_SCREEN_DURATION)
            when (event) {
                is UiEvent.Navigate -> {
                    navController.navigate(event.route) {
                        popUpTo(0)
                    }
                }
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Lottie(R.raw.shopping)
    }
}