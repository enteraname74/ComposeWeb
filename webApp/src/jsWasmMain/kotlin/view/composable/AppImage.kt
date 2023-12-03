package view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppImage(
    resource: String,
    contentDescription: String,
    size: Dp
) {
    Image(
        painter = painterResource(resource),
        contentDescription = contentDescription,
        modifier = Modifier.size(size)
    )
}