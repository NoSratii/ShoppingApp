package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.presentation.screen.home.OrderItemsState
import com.androiddev.shoppingapp.ui.theme.*
import java.math.BigDecimal

@Composable
fun OrderSummary(orderState: OrderItemsState) {
    Surface(color = MaterialTheme.colors.ItemBackgroundColor) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color =
                        MaterialTheme.colors.ItemBackgroundColor, shape = RoundedCornerShape(4.dp)
                    ),
                onClick = {},
                enabled = orderState.totalPrice >= BigDecimal(50000.0),
            ) {
                Text(
                    text = if (orderState.totalPrice >= BigDecimal(50000.0))
                        stringResource(id = R.string.Complete_purchase) else
                        stringResource(id = R.string.minimum_purchase, 50000),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = orderState.totalPrice.toString() + " t",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = MaterialTheme.colors.TitleColor,
                    textAlign = TextAlign.End
                )
            )
        }
    }
}