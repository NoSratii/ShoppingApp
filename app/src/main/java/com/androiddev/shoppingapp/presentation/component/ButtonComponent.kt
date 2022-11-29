package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androiddev.shoppingapp.ui.theme.DisableButtonColor
import com.androiddev.shoppingapp.ui.theme.EnableButtonColor

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    text: String? = null,
    horizontalMargin: Double = 8.0,
    verticalMargin: Double = 8.0,
    enableBackgroundColor: Color = EnableButtonColor,
    disableBackgroundColor: Color = DisableButtonColor,
    enableBorderColor: Color = EnableButtonColor,
    disableBorderColor: Color = DisableButtonColor,
    borderWidth: Int = 1,
    enableContentStyle: TextStyle = MaterialTheme.typography.button.copy(
        color = Color.White,
        fontSize = 16.sp
    ),
    disableContentStyle: TextStyle = MaterialTheme.typography.button.copy(
        color = Color.Black,
        fontSize = 16.sp
    ),
    isEnable: Boolean = true,
    onClick: () -> Unit,
    horizontalContentPadding: Double = 12.0,
    verticalContentPadding: Double = 12.0,
    elevation: Double = 0.0,
    isFullWidth: Boolean = true,
    radius: Int = 12,
    isContentCenter: Boolean = true,
    isLoading: Boolean = false,
    iconId: Int? = null,
    minHeight: Double = 32.0,
    iconTintColor: Color? = null,
    widget: @Composable (() -> Unit)? = null
) {

    Box(
        modifier = modifier.padding(horizontal = horizontalMargin.dp, vertical = verticalMargin.dp)
    ) {
        Button(
            onClick = {
                if (!isLoading) {
                    onClick()
                }
            },
            modifier =
            if (isFullWidth) modifier
                .fillMaxWidth()
                .heightIn(min = minHeight.dp)
                .testTag("custom_button")
            else
                if (borderWidth > 0)
                    modifier
                        .border(
                            width = borderWidth.dp,
                            color = if (isEnable) enableBorderColor else disableBorderColor,
                            shape = RoundedCornerShape(radius.dp)
                        )
                        .shadow(elevation = elevation.dp)
                        .heightIn(min = minHeight.dp)
                        .testTag("custom_button")
                else
                    modifier
                        .heightIn(min = minHeight.dp)
                        .testTag("customButton"),

            enabled = isEnable,
            shape = RoundedCornerShape(radius.dp),
            border =
            BorderStroke(
                width = borderWidth.dp,
                color = if (isEnable) enableBorderColor else disableBorderColor,
            ),
            colors =
            ButtonDefaults.buttonColors(
                disabledBackgroundColor = disableBackgroundColor,
                backgroundColor = enableBackgroundColor
            ),
            contentPadding = PaddingValues(
                horizontal = horizontalContentPadding.dp,
                vertical = verticalContentPadding.dp,
            ),
        ) {
            if (isLoading) {
                LoadingAnimation()
            } else {
                if (widget == null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        iconId?.let {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = iconId),
                                contentDescription = "button icon",
                                tint = iconTintColor ?: Color.White,
                            )
                        }
                        if (iconId != null && text != null) {
                            Spacer(modifier = androidx.compose.ui.Modifier.width(4.dp))
                        }
                        text?.let {
                            Text(
                                text = text,
                                style = if (isEnable) enableContentStyle else disableContentStyle,
                                textAlign = if (isContentCenter) TextAlign.Center else TextAlign.Start,
                            )
                        }

                    }
                } else {
                    widget()
                }

            }
        }
    }
}


