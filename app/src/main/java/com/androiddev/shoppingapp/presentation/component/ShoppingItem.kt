package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.ui.theme.CardShadowColor
import com.androiddev.shoppingapp.ui.theme.DefaultRadius
import com.androiddev.shoppingapp.ui.theme.colorPrimary
import com.androiddev.shoppingapp.ui.theme.defaultElevation

@Composable
fun ShoppingItem(
    item: ShoppingEntity.ShoppingItem,
    onItemClick: () -> Unit = {},
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
                .clickable { onItemClick() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
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
                            text = item.subTitleId.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Text(
                            text = item.price.toString(),
                            fontSize = 12.sp,
                            color = colorPrimary,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorPrimary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                        )
                    }

                }

            }
        }
    }
}