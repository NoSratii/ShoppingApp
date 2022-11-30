package com.androiddev.shoppingapp.presentation.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.androiddev.shoppingapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.presentation.component.TopAppBarWithBack
import com.androiddev.shoppingapp.ui.theme.TitleColor
import com.androiddev.shoppingapp.ui.theme.colorprimarylight

@Composable
fun DetailsContent(state: DetailsState, navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopAppBarWithBack { navController.navigateUp() }
        HeaderImage(Modifier.weight(1f))
        MoreDetails(state, Modifier.weight(2f))
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
fun MoreDetails(
    state: DetailsState, modifier: Modifier
) {
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
        Column() {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                text = state.orderItems[0].name,
                color = MaterialTheme.colors.TitleColor,
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h1
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                text = state.orderItems[0].description,
                color = Color.DarkGray,
                fontSize = 18.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1
            )

        }

    }
}


