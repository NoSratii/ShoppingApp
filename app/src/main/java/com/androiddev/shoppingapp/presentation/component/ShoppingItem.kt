package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.presentation.screen.home.OrderItemsState
import com.androiddev.shoppingapp.ui.theme.CardShadowColor
import com.androiddev.shoppingapp.ui.theme.DefaultRadius
import com.androiddev.shoppingapp.ui.theme.colorPrimary
import com.androiddev.shoppingapp.ui.theme.defaultElevation

@Composable
fun ShoppingItem(
    orderItem: ShoppingEntity.OrderItems,
    onItemClick: () -> Unit = {},
    onAdded: (id: Long) -> Unit,
    onRemoved: (id: Long) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(all = 8.dp)
            .shadow(
                defaultElevation,
                ambientColor = CardShadowColor,
                spotColor = CardShadowColor,
                shape = RoundedCornerShape(
                    DefaultRadius
                )
            ),
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable { onItemClick() },
                        painter = painterResource(R.drawable.discount),
                        contentDescription = "",
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = orderItem.name,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = orderItem.price.toString(),
                            fontSize = 12.sp,
                            color = colorPrimary,
                            textAlign = TextAlign.Start

                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Counter(orderItem.count, { onAdded(orderItem.id) }, { onRemoved(orderItem.id) })
                }

            }
        }
    }
}