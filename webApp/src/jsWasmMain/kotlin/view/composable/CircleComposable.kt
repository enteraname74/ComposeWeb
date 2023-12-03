package view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import view.utils.ColorUtils

@Composable
fun CircleComposable(
    modifier: Modifier = Modifier,
    color: Color = ColorUtils.secondary,
    size: Dp
) {
    Spacer(
        modifier = Modifier
            .size(size)
            .background(
                color = color,
                shape = CircleShape
            ).composed { modifier }
    )
}