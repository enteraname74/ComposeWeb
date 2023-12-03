package view.composable.homecomposable.parts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import view.utils.Constants

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeElement(
    content: @Composable () -> Unit
) {
    val maxHeight = LocalWindowInfo.current.containerSize.height.dp - 64.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(maxHeight)
            .padding(top = Constants.Size.large, bottom = Constants.Size.extraLarge2),
        verticalArrangement = Arrangement.spacedBy(Constants.Size.large)
    ) {
        content()
    }
}