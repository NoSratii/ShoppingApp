package com.androiddev.shoppingapp.presentation.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Counter(
    value: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = Color.Transparent)
            .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(4.dp))
    )

    {

        Row(modifier = Modifier.fillMaxWidth()) {


            ClickableText(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = AnnotatedString("-"),
                style = TextStyle(fontSize = 22.sp, textAlign = TextAlign.Center),
                onClick = { onDecrease() })


            AnimatedContent(
                targetState = value,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { height -> height } + fadeIn() with
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {

                        slideInVertically { height -> -height } + fadeIn() with
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(

                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .alignByBaseline(),
                    text = "$targetCount",
                    style = MaterialTheme.typography.subtitle1.copy(textAlign = TextAlign.Center),
                    color = Color.Black,
                )
            }

            ClickableText(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = AnnotatedString("+"),
                style = TextStyle(fontSize = 22.sp, textAlign = TextAlign.Center),
                onClick = { onIncrease() })
        }

    }
}

