package view.composable.homecomposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import view.utils.ColorUtils
import view.utils.Constants

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeElement(
    title: String,
    content: @Composable () -> Unit
) {
    val maxHeight = LocalWindowInfo.current.containerSize.height

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight.dp),
        verticalArrangement = Arrangement.spacedBy(Constants.Padding.large)
    ) {
        Text(
            text = title,
            fontSize = Constants.TextSize.title,
            color = ColorUtils.onPrimary
        )
        content()
    }
}