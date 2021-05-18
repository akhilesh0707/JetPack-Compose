package com.aqube.compose.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = CutCornerShape(topEnd = 18.dp),
        large = RoundedCornerShape(0.dp)
)