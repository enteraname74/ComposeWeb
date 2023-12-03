package view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import view.utils.ColorUtils

@Composable
fun LineComposable(
    color: Color = ColorUtils.secondary,
    width: Dp,
    height: Dp = 10.dp
) {
    Spacer(
        modifier = Modifier
            .width(width)
            .height(height)
            .background(
                color = color,
                shape = RoundedCornerShape(50)
            )
    )
}