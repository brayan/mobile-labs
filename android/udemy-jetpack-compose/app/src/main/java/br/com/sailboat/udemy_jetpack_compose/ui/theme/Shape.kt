package br.com.sailboat.udemy_jetpack_compose.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(topEnd = 24.dp),
    large = RoundedCornerShape(0.dp)
)