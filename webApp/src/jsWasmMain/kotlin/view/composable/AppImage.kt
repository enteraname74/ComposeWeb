package view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppImage(
    resource: String,
    contentDescription: String,
    size: Dp,
    onClick : () -> Unit = {}
) {
    Image(
        modifier = Modifier
            .size(size)
            .clickable { onClick() },
        painter = painterResource(resource),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
    )
}