package com.androiddev.shoppingapp.presentation.component.alertdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.androiddev.shoppingapp.presentation.component.ButtonComponent
import com.androiddev.shoppingapp.presentation.component.Lottie
import com.androiddev.shoppingapp.R

@Composable
fun AlertDialogComponent(
    modifier: Modifier = Modifier,
    title: String?,
    message: String,
    onCallback: () -> Unit,
) {

    ActionableDialog(modifier, title, message, onCallback)

}

@Composable
fun ActionableDialog(
    modifier: Modifier = Modifier,
    title: String?,
    message: String,
    onCallback: () -> Unit,
    properties: DialogProperties = DialogProperties()
) {

    Dialog(onDismissRequest = onCallback) {
        Card(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {
            Column(
                modifier
                    .background(Color.White)
                    .padding(vertical = 16.dp, horizontal = 8.dp)
            ) {
                Column(Modifier.align(Alignment.CenterHorizontally)) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(80.dp)
                            .height(80.dp)
                    ) {
                        Lottie(R.raw.shopping)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                ButtonComponent(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.confirm),
                    onClick = onCallback,
                    horizontalMargin = 8.0,
                    verticalMargin = 0.0
                )

            }
        }
    }
}

