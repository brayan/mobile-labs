package br.com.sailboat.udemy_jetpack_compose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val VeryLightGray = Color(0x60DCDCDC)
val LightGreen200 = Color(0x9932CD32)

@get:Composable
val Colors.LightGreen: Color
    get() = LightGreen200