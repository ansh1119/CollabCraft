package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Modifier.upperBorder(thickness: Dp, color: Color): Modifier {
    val density = LocalDensity.current
    val strokeWidthPx = density.run { thickness.toPx() }
    return this then Modifier.drawBehind {
        val width = size.width
        val height = size.height

        drawLine(
            color = color,
            start = Offset(x = -width, y = 0f),
            end = Offset(x = width*2, y = 0f),
            strokeWidth = strokeWidthPx
        )
    }
}