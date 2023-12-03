package view.composable.homecomposable

import androidx.compose.foundation.layout.*
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
    val maxHeight = LocalWindowInfo.current.containerSize.height.dp - 64.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight)
            .padding(vertical = Constants.Size.medium),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.large)
    ) {
        Text(
            text = title,
            fontSize = Constants.TextSize.title,
            color = ColorUtils.onPrimary
        )
        content()
    }
}