package view.utils

import androidx.compose.ui.graphics.Color

/**
 * Palette for a color theme.
 */
data class Palette(
    val primary: Color,
    val secondary: Color,
    val onPrimary: Color = Color.White,
    val onSecondary: Color = Color.White,
    val highlight: Color = Color.White
)
