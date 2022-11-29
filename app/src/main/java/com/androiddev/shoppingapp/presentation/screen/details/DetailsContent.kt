package com.androiddev.shoppingapp.presentation.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.androiddev.shoppingapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.presentation.component.TopAppBarWithBack
import com.androiddev.shoppingapp.ui.theme.colorprimarylight

@Composable
fun DetailsContent(navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopAppBarWithBack { navController.navigateUp() }
        HeaderImage(Modifier.weight(1f))
        MoreDetails(Modifier.weight(2f))
    }

}

@Composable
fun HeaderImage(modifier: Modifier) {

    Box(
        modifier = modifier
            .background(color = Color.White)
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.discount),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
        )
    }
}

@Composable
fun MoreDetails(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(40.dp)
                    .copy(
                        bottomStart = ZeroCornerSize,
                        bottomEnd = ZeroCornerSize
                    )
            )
            .background(color = colorprimarylight),

        ) {

    }
}


