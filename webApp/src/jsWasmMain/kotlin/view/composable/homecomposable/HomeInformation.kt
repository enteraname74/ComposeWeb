package view.composable.homecomposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import view.composable.CircleComposable
import view.utils.Constants

@Composable
fun HomeInformation() {
    HomeElement(
        title = "Home"
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                horizontalArrangement = Arrangement.spacedBy(Constants.Size.medium),
                verticalAlignment = Alignment.Bottom
            ) {
                CircleComposable(
                    size = 64.dp
                )
                CircleComposable(
                    size = 128.dp
                )
            }
        }
    }
}