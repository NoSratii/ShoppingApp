package com.androiddev.shoppingapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Teal200 = Color(0xFF03DAC5)
val BlueGrey900 = Color(0xFF263238)
val Grey100 = Color(0xFFF5F5F5)

val LoadingStartColor = Color(0xFF969696)
val LoadingEndColor = Color(0xFFCEDEE1)

val colorPrimary = Color(0xFF1BA57B)
val colorprimarylight = Color(0xFF60C0A2)

val CardShadowColor = Color(0x801D1D1D)

val EnableButtonColor = Color(0xFF1BA57B)
val DisableButtonColor = Color(0xFFF1F1F1)


val Colors.AppThemeColor
    get() = if (isLight) Color.White else Color.Black

val Colors.AppContentColor
    get() = if (isLight) Color.Black else Color.White

val Colors.TitleColor
    get() = if (isLight) Color.Black else Color.White

val Colors.ItemBackgroundColor get() = if (isLight) colorprimarylight else BlueGrey900