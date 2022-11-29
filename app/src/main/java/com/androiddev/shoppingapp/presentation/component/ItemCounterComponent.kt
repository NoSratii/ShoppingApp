package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AddCircleOutline
import androidx.compose.material.icons.sharp.RemoveCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Counter(
) {
    var count by remember { mutableStateOf(1) }

    Row {
        Icon(Icons.Sharp.RemoveCircleOutline,
            contentDescription = "minus",
            modifier = Modifier
                .alpha(if (count > 1) 1f else .4f)
                .clickable {
                    if (count > 1) {
                        count--
                    }
                })

        Text(
            count.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(40.dp)
        )

        Icon(
            Icons.Sharp.AddCircleOutline,
            contentDescription = "plus",
            modifier = Modifier
                .alpha(if (count < 10) 1f else .4f)
                .clickable {
                    if (count < 10) {
                        count++
                    }
                })
    }
}
